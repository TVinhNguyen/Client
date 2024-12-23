package Model;

import java.time.LocalDateTime;

import javafx.scene.control.Button;

public class TemporaryTableRow {
private String nameProduct;
private String priceProduct;
private int numberProduct;
private String sumNumberProduct;
private String nameStaffOrder;
private String timeOrder;
private String status;
private Button editProduct;

public TemporaryTableRow(String nameProduct, String priceProduct, int numberProduct, String sumNumberProduct,
		String nameStaffOrder, String timeOrder,String status ,Button editProduct) {
	super();
	this.nameProduct = nameProduct;
	this.priceProduct = priceProduct;
	this.numberProduct = numberProduct;
	this.sumNumberProduct = sumNumberProduct;
	this.nameStaffOrder = nameStaffOrder;
	this.timeOrder = timeOrder;
	this.editProduct = editProduct;
	this.status=status;
}
public String getNameStaffOrder() {
	return nameStaffOrder;
}
public void setNameStaffOrder(String nameStaffOrder) {
	this.nameStaffOrder = nameStaffOrder;
}
public String getTimeOrder() {
	return timeOrder;
}
public void setTimeOrder(String timeOrder) {
	this.timeOrder = timeOrder;
}
public String getNameProduct() {
	return nameProduct;
}
public void setNameProduct(String nameProduct) {
	this.nameProduct = nameProduct;
}
public String getPriceProduct() {
	return priceProduct;
}
public void setPriceProduct(String priceProduct) {
	this.priceProduct = priceProduct;
}
public int getNumberProduct() {
	return numberProduct;
}
public void setNumberProduct(int numberProduct) {
	this.numberProduct = numberProduct;
}
public String getSumNumberProduct() {
	return sumNumberProduct;
}
public void setSumNumberProduct(String sumNumberProduct) {
	this.sumNumberProduct = sumNumberProduct;
}
public Button getEditProduct() {
	return editProduct;
}
public void setEditProduct(Button editProduct) {
	this.editProduct = editProduct;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
