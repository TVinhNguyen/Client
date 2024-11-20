package TableRow;

import javafx.scene.control.Button;

public class PayMentTableRow {
private String nameProduct;
private String value;
private String node;
private Button button;
public PayMentTableRow(String nameProduct, String value, String node, Button button) {
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
public String getValue() {
	return value;
}
public void setValue(String value) {
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
