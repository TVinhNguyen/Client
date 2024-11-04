package Controller;

import Model.Item;
import Model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceManager {
    private List<OrderItem> currentOrderItems;

    public FoodServiceManager() {
        this.currentOrderItems = new ArrayList<>();
    }

    public void addItem(Item item, int quantity) {
        // Kiểm tra nếu món ăn đã tồn tại trong đơn hàng
        for (OrderItem orderItem : currentOrderItems) {
            if (orderItem.getItem().getName().equals(item.getName())) {
                // Cập nhật số lượng nếu món ăn đã tồn tại
                orderItem.setQuantity(orderItem.getQuantity() + quantity);
                return;
            }
        }
        // Nếu không, thêm món ăn mới vào đơn hàng
        currentOrderItems.add(new OrderItem(item, quantity));
    }

    public void removeItem(Item item) {
        // Xóa món ăn khỏi đơn hàng nếu có
        currentOrderItems.removeIf(orderItem -> orderItem.getItem().getName().equals(item.getName()));
    }

    public List<OrderItem> getCurrentOrderItems() {
        return currentOrderItems;
    }

    public double calculateTotal() {
        // Tính tổng giá của đơn hàng
        return currentOrderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public void displayOrder() {
        // Hiển thị danh sách các món ăn trong đơn hàng
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
