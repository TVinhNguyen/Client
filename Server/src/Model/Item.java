package Model;

public class Item {
    private static int itemCounter = 0;
    private String itemId;
    private String linkImage;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Item(int id ,String linkImage, String name, double price , int quantity) {
        this.linkImage = linkImage;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    
    public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public static int getItemCounter() {
		return itemCounter;
	}


	public static void setItemCounter(int itemCounter) {
		Item.itemCounter = itemCounter;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getLinkImage() {
		return linkImage;
	}


	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
    public String toString() {
        return "Item ID: " + itemId + " - " + name + " - " + price + " VND";
    }
}
