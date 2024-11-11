package Model;

import java.sql.Time;

import javafx.scene.control.Button;

public class CustomerTableRow {
   private int idCustomer;
   private String nameCustomer;
   private String phoneCustomer;
   private String nameAccount;
   private String passwordAccount;
   private int pointAccount;
   private Time remainTime;
   private Button showCustomer;
public CustomerTableRow(int idCustomer, String nameCustomer, String phoneCustomer, String nameAccount,
		String passwordAccount, int pointAccount, Time remainTime, Button showCustomer) {
	super();
	this.idCustomer = idCustomer;
	this.nameCustomer = nameCustomer;
	this.phoneCustomer = phoneCustomer;
	this.nameAccount = nameAccount;
	this.passwordAccount = passwordAccount;
	this.pointAccount = pointAccount;
	this.remainTime = remainTime;
	this.showCustomer = showCustomer;
}
public int getIdCustomer() {
	return idCustomer;
}
public void setIdCustomer(int idCustomer) {
	this.idCustomer = idCustomer;
}
public String getNameCustomer() {
	return nameCustomer;
}
public void setNameCustomer(String nameCustomer) {
	this.nameCustomer = nameCustomer;
}
public String getPhoneCustomer() {
	return phoneCustomer;
}
public void setPhoneCustomer(String phoneCustomer) {
	this.phoneCustomer = phoneCustomer;
}
public String getNameAccount() {
	return nameAccount;
}
public void setNameAccount(String nameAccount) {
	this.nameAccount = nameAccount;
}
public String getPasswordAccount() {
	return passwordAccount;
}
public void setPasswordAccount(String passwordAccount) {
	this.passwordAccount = passwordAccount;
}
public int getPointAccount() {
	return pointAccount;
}
public void setPointAccount(int pointAccount) {
	this.pointAccount = pointAccount;
}
public Time getRemainTime() {
	return remainTime;
}
public void setRemainTime(Time remainTime) {
	this.remainTime = remainTime;
}
public Button getShowCustomer() {
	return showCustomer;
}
public void setShowCustomer(Button showCustomer) {
	this.showCustomer = showCustomer;
}
   
}
