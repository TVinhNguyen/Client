package Model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private byte[] imageProduct;
    private int quantityProduct;
    private boolean statusProduct;
	private int idCategory;
    
 public Product(int idProduct, String nameProduct, double priceProduct, byte[] imageProduct, int quantityProduct,
		boolean statusProduct,int idCategory) {
	    super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.imageProduct = imageProduct;
		this.quantityProduct = quantityProduct;
		this.statusProduct=statusProduct;
		this.idCategory = idCategory;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}
	public byte[] getImageProduct() {
		return imageProduct;
	}
	public void setImageProduct(byte[] imageProduct) {
		this.imageProduct = imageProduct;
	}
	public int getQuantityProduct() {
		return quantityProduct;
	}
	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
    public boolean isStatusProduct() {
		return statusProduct;
	}
	public void setStatusProduct(boolean statusProduct) {
		this.statusProduct = statusProduct;
	}
}
