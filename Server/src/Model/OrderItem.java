package Model;

public class OrderItem {
    private static int itemCounter = 0;
    private int itemId;
    private Item item;
    private int quantity;

    public OrderItem(Item item, int quantity) {
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


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

   

    @Override
    public String toString() {
        return "Item ID: " + itemId + " - " + item.getName() + " x " + quantity + " = " + getTotalPrice() + " VND";
    }
}
