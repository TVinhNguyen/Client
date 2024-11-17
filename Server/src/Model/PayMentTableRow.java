package Model;

import javafx.scene.control.Button;

public class PayMentTableRow {
private String nameProduct;
private Double value;
private String node;
private Button button;
public PayMentTableRow(String nameProduct, Double value, String node, Button button) {
	super();
	this.nameProduct = nameProduct;
	this.value = value;
	this.node = node;
	this.button = button;
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
public Button getButton() {
	return button;
}
public void setButton(Button button) {
	this.button = button;
}

}
