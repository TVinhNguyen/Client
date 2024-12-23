package Model;

import java.time.LocalDateTime;

public class Temporary {
private int idTemporary;
private int turn;
private int idCustomer;
private int idProduct;
private int numberProduct;
private int idStaff;
private LocalDateTime timeOrder;
private int idComputer;
public Temporary(int idTemporary,int turn, int idCustomer, int idProduct, int numberProduct, int idStaff,
		LocalDateTime timeOrder, int idComputer) {
	super();
	this.idTemporary = idTemporary;
	this.turn=turn;
	this.idCustomer = idCustomer;
	this.idProduct = idProduct;
	this.numberProduct = numberProduct;
	this.idStaff = idStaff;
	this.timeOrder = timeOrder;
	this.idComputer = idComputer;
}
public int getIdTemporary() {
	return idTemporary;
}
public void setIdTemporary(int idTemporary) {
	this.idTemporary = idTemporary;
}
public int getTurn() {
	return turn;
}
public void setTurn(int turn) {
	this.turn = turn;
}
public int getIdCustomer() {
	return idCustomer;
}
public void setIdCustomer(int idCustomer) {
	this.idCustomer = idCustomer;
}
public int getIdProduct() {
	return idProduct;
}
public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
}
public int getNumberProduct() {
	return numberProduct;
}
public void setNumberProduct(int numberProduct) {
	this.numberProduct = numberProduct;
}
public int getIdStaff() {
	return idStaff;
}
public void setIdStaff(int idStaff) {
	this.idStaff = idStaff;
}
public LocalDateTime getTimeOrder() {
	return timeOrder;
}
public void setTimeOrder(LocalDateTime timeOrder) {
	this.timeOrder = timeOrder;
}
public int getIdComputer() {
	return idComputer;
}
public void setIdComputer(int idComputer) {
	this.idComputer = idComputer;
}

}
