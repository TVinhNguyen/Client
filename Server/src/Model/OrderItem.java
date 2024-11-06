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

    public static int getItemCounter() {
		return itemCounter;
	}


	public static void setItemCounter(int itemCounter) {
		OrderItem.itemCounter = itemCounter;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public Product getItem() {
		return item;
	}


	public void setItem(Product item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


    public double getTotalPrice() {
        return item.getPriceProduct() * quantity;
    }

   

    @Override
    public String toString() {
        return "Item ID: " + itemId + " - " + item.getNameProduct() + " x " + quantity + " = " + getTotalPrice() + " VND";
    }
}
