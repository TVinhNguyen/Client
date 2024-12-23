//package Utils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.sql.SQLException;
//import java.text.NumberFormat;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//import java.util.Locale;
//
//import Controller.Client;
//import Controller.UserService;
//import Controller_UI.ControllerChat;
//import Controller_UI.ControllerHome;
//import Manager.MessageManager;
//import Manager.NewManager;
//import Manager.ProductManager;
//import Model.ChatMessage;
//import Model.New;
//import Model.Product;
//import Model.UserAccount;
//import javafx.application.Platform;
//
//public class SocketManager extends Thread {
//    private Socket socket;
//    private PrintWriter output;
//    private BufferedReader input;
//    public static String responseServer = "";
//    public UserService userService;
//    public ProductManager productManager;
//    private volatile boolean running = true; 
//	public MessageManager messageManager = MessageManager.getInstance();
//    private Client client;
//		
//    public SocketManager() {
//        try {
//            socket = new Socket("localhost", 7891);
//            output = new PrintWriter(socket.getOutputStream(), true);
//            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            userService = new UserService(output , input);
//    		client = Client.getInstance();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        String response;
//        try {
//            while (running && (response = input.readLine()) != null) {
//                System.out.println("Server response: " + response);
//                responseServer = response;
//                handleCommand(responseServer);
//                
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading from server: " + e.getMessage());
//        } finally {
//            cleanup();
//        }
//    }
//
//    public void sendMessage(String message) {
//        if (output != null) {
//            output.println(message);
//        }
//    }
//
//    public void close() {
//        running = false; 
//        try {
//            if (socket != null) socket.close();
//            System.out.println("Closed connection");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void handleCommand(String command) {
//        String[] parts = command.split("-",2);
//        String action = parts[0];
//
//        switch (action) {
//        case "Account" : 
//        	String user = parts[1];
//		    client.setUser(UserAccount.fromString(user));
//		    break;
//        case "LIST_PRODUCT":
//            	 String jsonProduct = parts[1];
//                 fileJson.parseJsonToProducts(jsonProduct);
//            
//             break;
//        case "LIST_CATEGORY":
//        	 String jsonCategory = parts[1];
//             fileJson.parseJsonToCategory(jsonCategory);
//             break;
//        case "LIST_NEW":
//        		String jsonNew = parts[1];
//        		fileJson.parseJsonToNews(jsonNew);
//        	break;
//        case "SEND_MESSAGE":
//        	String message = parts[1];
//        	try {
//        	    ControllerChat cl = (ControllerChat) LoadRoot.getInstance().getController();
//        	    if (cl != null) {
//        	        cl.getMessage(new ChatMessage("ADMIN", message, false));
//        	    } 
//        	} catch (Exception e) {
////        	    e.printStackTrace();
//        		messageManager.addMessage(new ChatMessage("ADMIN", message, false));
//        	}
//        	break;
//        case "DEPOSIT_MONEY":
//        	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
//			String remainingMoney = parts[1];
//			System.out.println(remainingMoney);
//		    String remainingMoneyText = currencyFormat.format(Double.valueOf(remainingMoney)).replaceAll("[^0-9,.]", "").trim();
//		    this.client.getUser().setBalance(Double.valueOf(remainingMoney));
//		    try {
//        	    ControllerHome cl = (ControllerHome) LoadRoot.getInstance().getController();
//        	    if (cl != null) {
//        	    	
//        	    	 Platform.runLater(() -> cl.setTextRemainingMoney(remainingMoneyText));
//        	    } 
//        	} catch (Exception e) {
//
//        	}
//			break;
//
//        	
//        }
//    }
//  
//
//    public void cleanup() {
//        try {
//            if (input != null) input.close();
//            if (output != null) output.close();
//            if (socket != null) socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import Controller.Client;
import Controller.UserService;
import Controller_UI.ControllerChat;
import Controller_UI.ControllerHome;
import Manager.MessageManager;
import Manager.ProductManager;
import Model.ChatMessage;
import Model.UserAccount;
import javafx.application.Platform;

public class SocketManager extends Thread {
    private static final String MULTICAST_GROUP = "230.0.0.0"; // Nhóm multicast
    private static final int MULTICAST_PORT = 12345;          // Cổng multicast
    private static final int TCP_PORT = 7891;                // Cổng TCP

    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;
    public static String responseServer = "";
    public UserService userService;
    public ProductManager productManager;
    private volatile boolean running = true;
    public MessageManager messageManager = MessageManager.getInstance();
    private Client client;

    public SocketManager() {
        try {
//<<<<<<< HEAD
//            socket = new Socket("10.10.0.135", 7891);
//=======
            // Nhận địa chỉ IP từ UDP multicast
            String serverIP = receiveServerIP();
            if (serverIP == null) {
                throw new IOException("Không nhận được địa chỉ IP từ server qua multicast.");
            }

            // Kết nối TCP với địa chỉ IP nhận được
            socket = new Socket(serverIP, TCP_PORT);
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userService = new UserService(output, input);
            client = Client.getInstance();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String response;
        try {
            while (running && (response = input.readLine()) != null) {
                System.out.println("Server response: " + response);
                responseServer = response;
                handleCommand(responseServer);
            }
        } catch (IOException e) {
            System.out.println("Error reading from server: " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    public void sendMessage(String message) {
        if (output != null) {
            output.println(message);
        }
    }

    public void close() {
        running = false;
        try {
            if (socket != null) socket.close();
            System.out.println("Closed connection");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleCommand(String command) {
        String[] parts = command.split("-", 2);
        String action = parts[0];

        switch (action) {
            case "Account":
                String user = parts[1];
                client.setUser(UserAccount.fromString(user));
                break;
            case "LIST_PRODUCT":
                String jsonProduct = parts[1];
                fileJson.parseJsonToProducts(jsonProduct);
                break;
            case "LIST_CATEGORY":
                String jsonCategory = parts[1];
                fileJson.parseJsonToCategory(jsonCategory);
                break;
            case "LIST_NEW":
                String jsonNew = parts[1];
                fileJson.parseJsonToNews(jsonNew);
                break;
            case "SEND_MESSAGE":
                String message = parts[1];
                try {
                    ControllerChat cl = (ControllerChat) LoadRoot.getInstance().getController();
                    if (cl != null) {
                        cl.getMessage(new ChatMessage("ADMIN", message, false));
                    }
                } catch (Exception e) {
                    messageManager.addMessage(new ChatMessage("ADMIN", message, false));
                }
                break;
            case "DEPOSIT_MONEY":
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                String remainingMoney = parts[1];
                System.out.println(remainingMoney);
                String remainingMoneyText = currencyFormat.format(Double.valueOf(remainingMoney)).replaceAll("[^0-9,.]", "").trim();
                this.client.getUser().setBalance(Double.valueOf(remainingMoney));
                try {
                    ControllerHome cl = (ControllerHome) LoadRoot.getInstance().getController();
                    if (cl != null) {
                        Platform.runLater(() -> cl.setTextRemainingMoney(remainingMoneyText));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private String receiveServerIP() {
        try (MulticastSocket multicastSocket = new MulticastSocket(MULTICAST_PORT)) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            multicastSocket.joinGroup(group);

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("Đang chờ nhận địa chỉ IP từ server...");

            multicastSocket.receive(packet);
            String serverIP = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Đã nhận địa chỉ IP từ server: " + serverIP);

            multicastSocket.leaveGroup(group);
            return serverIP;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cleanup() {
        try {
            if (input != null) input.close();
            if (output != null) output.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

