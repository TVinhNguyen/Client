package Model;

public class DetailBill {
private int idDetail;
private int idBillHistory;
private int idProduct;
private int quantityProduct;
private Double sumMoneyProduct;

public DetailBill(int idDetail, int idBillHistory, int idProduct, int quantityProduct, Double sumMoneyProduct) {
	super();
	this.idDetail = idDetail;
	this.idBillHistory = idBillHistory;
	this.idProduct = idProduct;
	this.quantityProduct = quantityProduct;
	this.sumMoneyProduct = sumMoneyProduct;
}
public int getIdDetail() {
	return idDetail;
}
public void setIdDetail(int idDetail) {
	this.idDetail = idDetail;
}
public int getIdBillHistory() {
	return idBillHistory;
}
public void setIdBillHistory(int idBillHistory) {
	this.idBillHistory = idBillHistory;
}
public int getIdProduct() {
	return idProduct;
}
public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
}
public int getQuantityProduct() {
	return quantityProduct;
}
public void setQuantityProduct(int quantityProduct) {
	this.quantityProduct = quantityProduct;
}
public Double getSumMoneyProduct() {
	return sumMoneyProduct;
}
public void setSumMoneyProduct(Double sumMoneyProduct) {
	this.sumMoneyProduct = sumMoneyProduct;
}

}
