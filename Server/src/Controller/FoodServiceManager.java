package Controller;


import Model.Item;
import Model.Order;
import Model.UserAccount;

public class FoodServiceManager {
    private Order currentOrder;
    private UserAccount userAccount;

    public FoodServiceManager(UserAccount userAccount) {
        this.userAccount = userAccount;
        this.currentOrder = new Order();
    }

    public void addItemToOrder(Item item, int quantity) {
        currentOrder.addItem(item, quantity);
    }

    public void removeItemFromOrder(Item item) {
        currentOrder.removeItem(item);
    }

    public void checkout(boolean payWithAccountBalance) {
        double totalCost = currentOrder.getTotalCost();
        if (payWithAccountBalance) {
            if (userAccount.withdraw(totalCost)) {
                System.out.println("Payment for Order ID: " + currentOrder.getOrderId() + " successful.");
            } else {
                System.out.println("Payment failed. Insufficient balance.");
            }
        } else {
            System.out.println("Please pay " + totalCost + " VND separately.");
        }
    }

    public void displayOrder() {
        currentOrder.displayOrder();
    }
}

