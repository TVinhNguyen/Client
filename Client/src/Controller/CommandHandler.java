package Controller;

import Model.Product;
import javafx.stage.Stage;

import java.util.Scanner;

public class CommandHandler {
    private static Client client = Client.getInstance();

    public CommandHandler() {
    }

  

 
    public  static void changePlayTime(int amount, int hours) {
    	String query = "CHANGE_PLAYTIME-" +  amount + " " + hours;
    	client.sendMessage(query);
    
    	
    }
    public static void depositMoney(String amount) 
    {
    	String query = "DEPOSIT_MONEY-" + amount;
    	client.sendMessage(query);
    }
    public static void loginUser(String username , String password , int id)
    {
	  	String send = "LOGIN_USER-" + username + " " + password + " "+id;
	  	client.sendMessage(send);
    }
    public static void sendMessage(String message , String username) 
    {
        String messageForm = "SEND_MESSAGE-" +username + ":" + message;
        client.sendMessage(messageForm);
    }
    public static void sendOrder(String order) 
    {
    	String query = "ORDER_FOOD-"+order;
    	client.sendMessage(query);
    }
    
    public static void logOut()
    {
    	String query = "LOG_OUT";
    	client.sendMessage(query);
    	
    }

}
