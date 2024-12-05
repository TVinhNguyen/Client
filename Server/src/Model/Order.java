package Model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int orderCounter = 0;
    
    private int orderId;
    
    private static Map<Product, OrderItem> items;

	private double totalCost;

    
    public static Map<Product, OrderItem> getItems() {
		return items;
	}

	public void setItems(Map<Product, OrderItem> items) {
		this.items = items;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
    public Order() {
        this.orderId = ++orderCounter;
        items = new HashMap<>();
        totalCost = 0;
    }

    public void addItem(Product item, int quantity) {
        if (items.containsKey(item)) {
            OrderItem existingItem = items.get(item);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            items.put(item, new OrderItem(item, quantity));
        }
        totalCost += item.getPriceProduct() * quantity;
        System.out.println("Added to Order ID: " + orderId + " - " + item.getNameProduct() + " x " + quantity);
    }

    public void removeItem(Product item) {
        if (items.containsKey(item)) {
            OrderItem orderItem = items.remove(item);
            totalCost -= orderItem.getTotalPrice();
            System.out.println("Removed: " + item.getNameProduct() + " from order.");
        } else {
            System.out.println("Item not found in the order.");
        }
    }
    public double getTotalCost() {
        return totalCost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId + " - Items:");
        for (OrderItem orderItem : items.values()) {
            System.out.println(orderItem);
        }
        System.out.println("Total cost: " + totalCost + " VND");
    }
}


