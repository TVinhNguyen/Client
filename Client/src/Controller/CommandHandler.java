package Controller;

import Model.Item;

import java.util.Scanner;

public class CommandHandler {
    private UserService userService;

    public CommandHandler(UserService userService) {
        this.userService = userService;
    }

    public void handleCommand(String command) {
        switch (command.toUpperCase()) {
            case "ADD_ITEM":
                addItem();
                break;
            case "REMOVE_ITEM":
                removeItem();
                break;
            case "SEND_ORDER":
                userService.sendOrder();
                break;
            case "VIEW_ORDER":
                viewOrder();
                break;
            default:
                System.out.println("Unknown command. Please try again.");
        }
    }

    private void addItem() {
//        System.out.print("Enter item name: ");
//        String itemName = scanner.nextLine();
//        System.out.print("Enter quantity: ");
//        int quantity = Integer.parseInt(scanner.nextLine());
//        userService.addItemToOrder(itemName, quantity);
    }

    private void removeItem() {
//        System.out.print("Enter item name to remove: ");
//        String itemName = scanner.nextLine();
//        userService.removeItemFromOrder(itemName);
    }

    private void viewOrder() {
        System.out.println("Current order items: " + userService.getCurrentOrderItems());
    }
    private void login() {
    	
    }
}
