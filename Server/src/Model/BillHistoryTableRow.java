package Model;

import java.sql.Date;

import javafx.scene.control.Button;

public class BillHistoryTableRow {
private String nameStaff;
private String nameCustomer;
private String nameComputer;
private String namePromotion;
private Date datePaymentBill;
private String formPaymentBill;
private String sumMoneyBill;
private Button show;
public Button getShow() {
	return show;
}
public void setShow(Button show) {
	this.show = show;
}
public String getNameStaff() {
	return nameStaff;
}
public void setNameStaff(String nameStaff) {
	this.nameStaff = nameStaff;
}
public String getNameCustomer() {
	return nameCustomer;
}
public void setNameCustomer(String nameCustomer) {
	this.nameCustomer = nameCustomer;
}
public String getNameComputer() {
	return nameComputer;
}
public void setNameComputer(String nameComputer) {
	this.nameComputer = nameComputer;
}
public String getNamePromotion() {
	return namePromotion;
}
public void setNamePromotion(String namePromotion) {
	this.namePromotion = namePromotion;
}
public Date getDatePaymentBill() {
	return datePaymentBill;
}
public void setDatePaymentBill(Date datePaymentBill) {
	this.datePaymentBill = datePaymentBill;
}
public String getFormPaymentBill() {
	return formPaymentBill;
}
public void setFormPaymentBill(String formPaymentBill) {
	this.formPaymentBill = formPaymentBill;
}
public String getSumMoneyBill() {
	return sumMoneyBill;
}
public void setSumMoneyBill(String sumMoneyBill) {
	this.sumMoneyBill = sumMoneyBill;
}
public BillHistoryTableRow(String nameStaff, String nameCustomer, String nameComputer, String namePromotion,
		Date datePaymentBill, String formPaymentBill, String sumMoneyBill,Button show) {
	super();
	this.nameStaff = nameStaff;
	this.nameCustomer = nameCustomer;
	this.nameComputer = nameComputer;
	this.namePromotion = namePromotion;
	this.datePaymentBill = datePaymentBill;
	this.formPaymentBill = formPaymentBill;
	this.sumMoneyBill = sumMoneyBill;
	this.show=show;
}

}
