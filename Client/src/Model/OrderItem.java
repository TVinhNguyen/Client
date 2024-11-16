package Model;

public class OrderItem {
    private static int itemCounter = 0;
    private int itemId;
    private Product item;
    private int quantity;

    public OrderItem(Product item, int quantity) {
        this.itemId = ++itemCounter;
        this.item = item;
        this.quantity = quantity;
    }

    public Product getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPriceProduct() * quantity;
    }

    public int getItemId() {
        return itemId;
    }
    public void setQuantity(int quantity) {
    	this.quantity=  quantity;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + " - " + item.getNameProduct() + " x " + quantity + " = " + getTotalPrice() + " VND";
    }
}
