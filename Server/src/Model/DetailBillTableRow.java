package Model;

public class DetailBillTableRow {
private int numberProduct;
private String nameProduct;
private int quantityProduct;
private String sumMoneyproduct;

public DetailBillTableRow(int numberProduct, String nameProduct, int quantityProduct, String sumMoneyproduct) {
	super();
	this.numberProduct = numberProduct;
	this.nameProduct = nameProduct;
	this.quantityProduct = quantityProduct;
	this.sumMoneyproduct = sumMoneyproduct;
}
public int getNumberProduct() {
	return numberProduct;
}
public void setNumberProduct(int numberProduct) {
	this.numberProduct = numberProduct;
}
public String getNameProduct() {
	return nameProduct;
}
public void setNameProduct(String nameProduct) {
	this.nameProduct = nameProduct;
}
public int getQuantityProduct() {
	return quantityProduct;
}
public void setQuantityProduct(int quantityProduct) {
	this.quantityProduct = quantityProduct;
}
public String getSumMoneyproduct() {
	return sumMoneyproduct;
}
public void setSumMoneyproduct(String sumMoneyproduct) {
	this.sumMoneyproduct = sumMoneyproduct;
}
}
