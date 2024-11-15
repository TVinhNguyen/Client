package Controller;

import Model.Product;

import java.util.Scanner;

public class CommandHandler {
    private static Client client;

    public CommandHandler() {
		client = Client.getInstance();
    }

  

    private void addItem() {
//        System.out.print("Enter item name: ");
//        String itemName = scanner.nextLine();
//        System.out.print("Enter quantity: ");
//        int quantity = Integer.parseInt(scanner.nextLine());
//        userService.addItemToOrder(itemName, quantity);
    }
    public  static void changePlayTime(int amount, int hours) {
    	String query = "CHANGE_PLAYTIME " +  amount + " " + hours;
    	client.sendMessage(query);
    
    	
    }
    public static void depositMoney(String amount) 
    {
    	String query = "DEPOSIT_MONEY " + amount;
    	client.sendMessage(query);
    }

    private void removeItem() {
//        System.out.print("Enter item name to remove: ");
//        String itemName = scanner.nextLine();
//        userService.removeItemFromOrder(itemName);
    }

    private void viewOrder() {
//        System.out.println("Current order items: " + userService.getCurrentOrderItems());
    }
    private void login() {
    	
    }
}
