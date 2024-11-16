package Controller;

import Model.Product;
import Model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceManager {
    private List<OrderItem> currentOrderItems;

    public FoodServiceManager() {
        this.currentOrderItems = new ArrayList<>();
    }

    public void addItem(Product item, int quantity) {
        for (OrderItem orderItem : currentOrderItems) {
            if (orderItem.getItem().getNameProduct().equals(item.getNameProduct())) {
                orderItem.setQuantity(orderItem.getQuantity() + quantity);
                return;
            }
        }
        currentOrderItems.add(new OrderItem(item, quantity));
    }

    public void removeItem(Product item) {
        currentOrderItems.removeIf(orderItem -> orderItem.getItem().getNameProduct().equals(item.getNameProduct()));
    }

    public List<OrderItem> getCurrentOrderItems() {
        return currentOrderItems;
    }

    public double calculateTotal() {
        return currentOrderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public void displayOrder() {
        if (currentOrderItems.isEmpty()) {
            System.out.println("No items in the order.");
        } else {
            System.out.println("Current order items:");
            for (OrderItem orderItem : currentOrderItems) {
                System.out.println(orderItem);
            }
            System.out.println("Total: " + calculateTotal() + " VND");
        }
    }
}
