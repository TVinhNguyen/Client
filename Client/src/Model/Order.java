package Model;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int orderCounter = 0;
    private int orderId;
    private Map<Item, OrderItem> items;
    private double totalCost;

    public Order() {
        this.orderId = ++orderCounter;
        items = new HashMap<>();
        totalCost = 0;
    }

    public void addItem(Item item, int quantity) {
        if (items.containsKey(item)) {
            OrderItem existingItem = items.get(item);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            items.put(item, new OrderItem(item, quantity));
        }
        totalCost += item.getPrice() * quantity;
        System.out.println("Added to Order ID: " + orderId + " - " + item.getName() + " x " + quantity);
    }

    public void removeItem(Item item) {
        if (items.containsKey(item)) {
            OrderItem orderItem = items.remove(item);
            totalCost -= orderItem.getTotalPrice();
            System.out.println("Removed: " + item.getName() + " from order.");
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

