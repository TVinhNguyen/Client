package Controller;

import Model.Product;
import Model.OrderItem;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private PrintWriter output;
    private BufferedReader input;
    private FoodServiceManager foodService;
    private boolean isLocked = false;
    private Client client;
	public UserService() {
		client = Client.getInstance();
	}


    public UserService(PrintWriter output, BufferedReader input) {
        this.output = output;
        this.input = input;
        this.foodService = new FoodServiceManager();
    }

	//    public void addItemToOrder(String itemName, int quantity) {
	//        Product item = new Product(itemName, getItemPrice(itemName));
	//        foodService.addItem(item, quantity);
	//        System.out.println("Added " + quantity + " of " + itemName + " to your order.");
	//    }
	//
	//    public void removeItemFromOrder(String itemName) {
	//        Product item = new Item(itemName, getItemPrice(itemName));
	//        foodService.removeItem(item);
	//        System.out.println("Removed " + itemName + " from your order.");
	//    }

    public void sendOrder() {
        double total = foodService.calculateTotal();
        output.println("SEND_ORDER " + total); // Chỉnh sửa theo định dạng yêu cầu của server
        System.out.println("Order sent. Total: " + total);
    }
    public void sendchangeplaytime(int amount , int hours) {
    	output.println("CHANGE_PLAYTIME " + amount + " " + hours);
    	
    }
    private double getItemPrice(String itemName) {
        return 10.0; 
    }
    public void lockScreen() {
        isLocked = true;
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Screen Locked");
            alert.setHeaderText("Your screen is locked!");
            alert.setContentText("Please enter the password to unlock.");
            alert.showAndWait();
        });
    }
    
    public List<OrderItem> getCurrentOrderItems() {
        return foodService.getCurrentOrderItems();
    }
}
