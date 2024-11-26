package Controller;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import Controller_UI.controllerAdmin;
import Controller_UI.controllerLogin;
import Model.UserAccount;

public class Server implements Runnable {
    private static final int PORT = 12345; 
    private static Map<String, UserAccount> userAccounts = new HashMap<>(); 
    public controllerLogin controllerLogin;

    public static void registerUser(UserAccount account) {
        userAccounts.put(account.getUserId(), account);
        System.out.println("User registered: " + account.getUsername());
    }

    public static UserAccount getUserAccount(int accountId) {
        return userAccounts.get(accountId);
    }
    public Server(controllerLogin controllerLogin) {
    	this.controllerLogin  = controllerLogin;
    }
	@Override
	public void run() {
		 try (ServerSocket serverSocket = new ServerSocket(PORT)) {
	            System.out.println("Server is listening on port " + PORT);
	            
	            while (true) {
	                Socket socket = serverSocket.accept(); 
	                System.out.println("New client connected");
	                
	                new ClientHandler(socket).start();
	            }
	        } catch (IOException ex) {
	            System.out.println("Server exception: " + ex.getMessage());
	            ex.printStackTrace();
	        }
		
	}
}
