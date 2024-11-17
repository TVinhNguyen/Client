package Model;

import java.sql.Date;

public class PayMent {
private int idPayMent;
private String nameProduct;
private Double value;
private String node;
private Date importDate;
public Date getImportDate() {
	return importDate;
}
public void setImportDate(Date importDate) {
	this.importDate = importDate;
}
public PayMent(int idPayMent, String nameProduct, Double value, String node,Date importDate) {
	super();
	this.idPayMent = idPayMent;
	this.nameProduct = nameProduct;
	this.value = value;
	this.node = node;
	this.importDate=importDate;
}
public int getIdPayMent() {
	return idPayMent;
}
public void setIdPayMent(int idPayMent) {
	this.idPayMent = idPayMent;
}
public String getNameProduct() {
	return nameProduct;
}
public void setNameProduct(String nameProduct) {
	this.nameProduct = nameProduct;
}
public Double getValue() {
	return value;
}
public void setValue(Double value) {
	this.value = value;
}
public String getNode() {
	return node;
}
public void setNode(String node) {
	this.node = node;
}
}
