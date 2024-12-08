package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Controller_UI.controllerUser;
import Dto.productDto;
import Manager.CategoryManager;
import Manager.NewsManager;
import Manager.ProductService;
import Dto.CategoryDto;
import Dto.ComputerDto;
import Dto.CustomerDto;
import Dto.NewDto;
import Dto.UserDto;
import Model.Category;
import Model.ChatMessage;
import Model.Computer;
import Model.Customer;
import Model.New;
import Model.Product;
import Model.UserAccount;
import Utils.LoadRoot;
import Utils.fileJson;

public class ClientHandler extends Thread {
    private Socket socket;
    private Customer customer;
    private BufferedReader input;
    private PrintWriter output;
    private Computer computer;
    private boolean running = true; 

    public ClientHandler(Socket socket) {
        this.socket = socket;
        ClientHandlerManager.getInstance().addClientHandler(this);

    }
    public Customer getCustomer() 
    {
    	return this.customer;
    }
    public Computer getComputer() 
    {
    	return this.computer;
    }
    
    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("chay");
            Thread receiveThread = new Thread(() -> {
                try {
                    String command;
                    while (running && (command = input.readLine()) != null) {
                        System.out.println("Received command: " + command);

                        handleCommand(command);
                        
                    }
                } catch (IOException ex) {
                    System.out.println("Client handler exception: " + ex.getMessage());
                }
            });
            receiveThread.start(); 

            Thread sendThread = new Thread(() -> {
                try {
                    while (running) {
//						
//						 ChatMessage messageToSend = chatService.getNextMessage(); if (messageToSend
//						 != null) { output.println("MESSAGE: " + messageToSend); }
						 
                       Thread.sleep(100); 
                    }
                } catch (Exception e) {
                    System.out.println("Send thread interrupted: " + e.getMessage());
                }
            });
            sendThread.start(); 
    	

        } catch (IOException  ex) {
            System.out.println("Exception in ClientHandler: " + ex.getMessage());
        } 
//        finally {
//            cleanup();
//        }
    }
    public void sendMessage(String message) {
    	output.println(message);
    }
    private void handleCommand(String command) {
        String[] parts = command.split("-");
        String action = parts[0];

        switch (action) {
        case "LOGIN_USER":
            String[] partsUser = parts[1].split(" ");

            List<Product> productss = new ArrayList<Product>();
            List<New> News = NewDto.getAllNews();
            List<Category> categories = CategoryDto.getALLCategorys();
             try {
            	 String username = partsUser[0];
                 String password = partsUser[1];
                 String idComputer = partsUser[2];
                 Customer user = CustomerDto.getByLogin(username, password); 
                 try {
             		List<Product> products= productDto.getAllProducts();
             		for(var product:products)
             		{
             			if(product.isStatusProduct())
             			{
             				productss.add(product);
             			}
             		}
             	} catch (Exception e) {
             		e.printStackTrace();
             	}
                 ProductService productService = new ProductService(); NewsManager newsManager = new NewsManager();
                 String jsonStringProduct = productService.convertProductsToString(productss);
                 String jsonStringNews = newsManager.convertNewsToString(News);
                 String jsonCategory = CategoryManager.convertCategoryToString(categories);
                 this.customer = user;
                 this.computer = ComputerDto.getComputer(Integer.valueOf(idComputer));
                 if (user != null) {
                	 try {
                    	 controllerUser cl = (controllerUser) LoadRoot.getInstance().getController();
                    	 cl.setComputerForUser(Integer.valueOf(idComputer),this.customer.getIdCustomer(),LocalDateTime.now());
					} catch (Exception e) {
						e.printStackTrace();
					}
                     output.println("Account-"+user);
                     output.println("LIST_PRODUCT-"+jsonStringProduct);
                     output.println("LIST_NEW-"+jsonStringNews);
                     output.println("LIST_CATEGORY-" + jsonCategory);
                 } else {
                     output.println("null");
                 }
             } catch (SQLException e) {
                 output.println("Error during login: " + e.getMessage());
             }
             break;
        case "CHANGE_PLAYTIME" :
        	try {
                 partsUser = parts[1].split(" ");

        		int id =  this.customer.getIdCustomer();
        		String money = partsUser[0];
        		String hour = partsUser[1];
        		
        		if(this.customer!= null)
        		{	try
        		{
        			this.customer.setRemainMoney(this.customer.getRemainMoney() - Double.valueOf(money));
        			this.customer.setRemainTime(this.customer.getRemainTime() + (3600 * Long.valueOf(hour)));
        			System.out.println(this.customer.getRemainMoney());
        			System.out.println(this.customer.getRemainTime());
        			CustomerDto.updateTime(id,this.customer.getRemainTime());
        			CustomerDto.updateBalance(id,this.customer.getRemainMoney());
            		output.println(this.customer.getRemainTime() + "," + this.customer.getRemainMoney());

        		} catch(SQLException e) {output.println("FAIL");}
        		}
        	} catch (Exception e) 
        	{
        		output.println("Error during login: " + e.getMessage());
        	}
        	break;
        case "REGISTER_USER":
             partsUser = parts[1].split(" ");

            String username = partsUser[0];
            String password = partsUser[1];
            try {
                UserAccount newUser = new UserAccount(username, password);
                UserDto.registerUser(newUser);
                output.println("User registered: " + username);
            } catch (SQLException e) {
                output.println("Error registering user: " + e.getMessage());
            }
            break;

        case "DEPOSIT_MONEY":
            double amount = Double.parseDouble(parts[1]);
            try {
             	 controllerUser cl = (controllerUser) LoadRoot.getInstance().getController();
              cl.notificationDeposit(this.computer.getIdComputer(),LocalDateTime.now(),amount);
              ComputerDto.setStatus(this.computer.getIdComputer(), 0);
              } catch (Exception e) {
  				e.printStackTrace();
  			}
            break;
        
        case "LOG_OUT":
        	LocalDateTime time = LocalDateTime.now();
        	try {
            	 controllerUser cl = (controllerUser) LoadRoot.getInstance().getController();
            	 
            	 cl.setTimeUser(this.customer.getIdCustomer(),time);

        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	break;

        case "ORDER_FOOD":
            try {
            	fileJson json = new fileJson();
            	json.jsonconvertOrder(parts[1]);
            	try {
                  	 controllerUser cl = (controllerUser) LoadRoot.getInstance().getController();
                  	 cl.notificationOrder(json.idComputer,json.isPaid, json.timePay,json.order);
                   } catch (Exception e) {
       				e.printStackTrace();
       			}
            	
            } catch (Exception e) {
                output.println("Order failed: " + e.getMessage());
            }
            break;
        case "SEND_MESSAGE":
            String sender = parts[1].split(":")[0]; 
            String messageContent = parts[1].split(":")[1]; 
            ChatMessage chatMessage = new ChatMessage(sender, messageContent,false);
            try {
           	 controllerUser cl = (controllerUser) LoadRoot.getInstance().getController();
           	 cl.addMessageToComputer(this.computer.getIdComputer(), chatMessage);
            } catch (Exception e) {
				e.printStackTrace();
			}
            break;
        case "TIME_USER":
        	String id = parts[1];
        	this.customer.getIdCustomer();
        	this.computer.getIdComputer();
        	break;

        default:
        	break;
     
        }
    }

    private void cleanup() {
        try {
            running = false; 
            ClientHandlerManager.getInstance().removeClientHandler(this);
            socket.close();
        } catch (IOException ex) {
            System.out.println("Socket close exception: " + ex.getMessage());
        }
    }
}
