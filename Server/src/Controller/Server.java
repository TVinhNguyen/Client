package Controller;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import Controller_UI.controllerAdmin;
import Model.UserAccount;

public class Server implements Runnable {
    private static final int PORT = 12345; 
    private static Map<String, UserAccount> userAccounts = new HashMap<>(); 
    public controllerAdmin controllerAdmin;

    public static void registerUser(UserAccount account) {
        userAccounts.put(account.getUserId(), account);
        System.out.println("User registered: " + account.getUsername());
    }

    public static UserAccount getUserAccount(int accountId) {
        return userAccounts.get(accountId);
    }
    public Server(controllerAdmin controllerAdmin) {
    	this.controllerAdmin  = controllerAdmin;
    }
	@Override
	public void run() {
		 try (ServerSocket serverSocket = new ServerSocket(PORT)) {
	            System.out.println("Server is listening on port " + PORT);
	            
	            while (true) {
	                Socket socket = serverSocket.accept(); // Chấp nhận kết nối
	                System.out.println("New client connected");
	                
	                new ClientHandler(socket).start();
	            }
	        } catch (IOException ex) {
	            System.out.println("Server exception: " + ex.getMessage());
	            ex.printStackTrace();
	        }
		
	}
}
