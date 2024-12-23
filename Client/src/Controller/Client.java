package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller_UI.ControllerLogin;
import Manager.NewManager;
import Manager.ProductManager;
import Model.Computer;
import Model.UserAccount;
import Utils.SocketManager;

public class Client {
    private static Client instance;
    private static SocketManager socketManager;
    private static UserAccount userAccount;
    private static Computer computer;
    private static ProductManager productManager;

    // Singleton pattern
    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
            initializeClient();
        }
        return instance;
    }

    private static void initializeClient() {
        socketManager = new SocketManager();
        socketManager.start(); // Start the socket connection
        computer = new Computer(2, "May q", 1); // Dummy data, update if needed
        productManager = ProductManager.getInstance();
       
    }

    // Send message to server
    public void sendMessage(String message) {
        if (socketManager != null) {
            socketManager.sendMessage(message);
        }
    }

    // Receive message from server
    public String receiMessage() {
        String response = SocketManager.responseServer;
        SocketManager.responseServer = ""; // Reset response
        return response;
    }

    // Set the current user
    public void setUser(UserAccount user) {
        userAccount = user;
    }

    // Get the current user
    public UserAccount getUser() {
        return userAccount;
    }

    public Computer getComputer() {
        return computer;
    }

    public void disconnect() {
        if (socketManager != null) {
            socketManager.cleanup(); 
        }
    }

    public void resetUserData() {
        userAccount = null;   	
        computer = null;      
        productManager.reset(); 
        NewManager.getInstance().reset();
    }

    public void reconnect() {
//        disconnect(); 
        initializeClient(); 
    }
}
