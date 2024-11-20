package Model;

import javafx.scene.control.Button;

public class TimeUserComputerTableRow {
private int index;
private String timeUser;
private String moneyUser;
private Button show;
private Button delete;
public TimeUserComputerTableRow(int index,String timeUser, String moneyUser, Button show, Button delete) {
	super();
	this.index=index;
	this.timeUser = timeUser;
	this.moneyUser = moneyUser;
	this.show = show;
	this.delete = delete;
}
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public String getTimeUser() {
	return timeUser;
}
public void setTimeUser(String timeUser) {
	this.timeUser = timeUser;
}
public String getMoneyUser() {
	return moneyUser;
}
public void setMoneyUser(String moneyUser) {
	this.moneyUser = moneyUser;
}
public Button getShow() {
	return show;
}
public void setShow(Button show) {
	this.show = show;
}
public Button getDelete() {
	return delete;
}
public void setDelete(Button delete) {
	this.delete = delete;
}

}
