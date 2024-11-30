package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
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

public class ClientHandler extends Thread {
    private Socket socket;
    private Customer customer;
    private BufferedReader input;
    private PrintWriter output;
    private Computer computer;
    private static List<ClientHandler> clientHandlers = new CopyOnWriteArrayList<>();
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
            clientHandlers.add(this);
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
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
        case "LOGIN_USER":
            List<Product> productss = new ArrayList<Product>();
            List<New> News = NewDto.getAllNews();
            List<Category> categories = CategoryDto.getALLCategorys();
             try {
            	 String username = parts[1];
                 String password = parts[2];
                 String idComputer = parts[3];
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
                    	 ComputerDto.setStatus(this.computer.getIdComputer(), 1);
                    	 cl.setComputerForUser(Integer.valueOf(idComputer),this.customer.getIdCustomer());
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
        		int id =  this.customer.getIdCustomer();
        		String money = parts[1];
        		String hour = parts[2];
        		
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
            String username = parts[1];
            String password = parts[2];
            try {
                UserAccount newUser = new UserAccount(username, password);
                UserDto.registerUser(newUser);
                output.println("User registered: " + username);
            } catch (SQLException e) {
                output.println("Error registering user: " + e.getMessage());
            }
            break;

        case "DEPOSIT_MONEY":
            int accountId = this.customer.getIdCustomer();
            double amount = Double.parseDouble(parts[1]);
            try {
                CustomerDto.depositToUser(accountId, amount);
                this.customer.setRemainMoney(this.customer.getRemainMoney() + amount);
                output.println("SUCCESS," + this.customer.getRemainMoney());
            } catch (SQLException e) {
                output.println("Error during deposit: " + e.getMessage());
            }
            break;
        
        case "GET_MENU":
            try {
                List<Product> menu = productDto.getAllProducts();
                for (Product item : menu) {
                    output.println(item.toString());
                }
                output.println("END"); 
            } catch (SQLException e) {
                output.println("Error retrieving menu: " + e.getMessage());
            }
            break;

        case "ORDER_FOOD":
            try {
                accountId = Integer.parseInt(parts[1]);
                int menuItemId = Integer.parseInt(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                double totalCost = productDto.getMenuItemById(menuItemId).getPriceProduct() * quantity;
                UserDto.deductFromUser(accountId, totalCost);
                output.println("Order successful. Remaining balance: " + UserDto.getUserBalance(accountId));
            } catch (SQLException e) {
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
				// TODO: handle exception
				e.printStackTrace();
			}

            break;

//        case "GET_MESSAGES":
//            for (ChatMessage message : chatService.getMessages()) {
//                output.println(message);
//            }
//            output.println("END"); 
//            break;
//        case "CLEAR_MESSAGES":
//            chatService.clearMessages(); 
//            output.println("Messages cleared.");
//            break;
        default:
        	break;
     
        }
    }

    private void cleanup() {
        try {
            running = false; 
            clientHandlers.remove(this);
            socket.close();
        } catch (IOException ex) {
            System.out.println("Socket close exception: " + ex.getMessage());
        }
    }
}
