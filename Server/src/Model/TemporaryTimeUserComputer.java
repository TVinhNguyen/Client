package Model;

import java.time.LocalDateTime;

public class TemporaryTimeUserComputer {
private int id;
private int idComputer;
private int idCustomer;
private int idTimeUserComputer;
private LocalDateTime timeOrder;
public TemporaryTimeUserComputer(int id, int idComputer, int idCustomer, int idTimeUserComputer,
		LocalDateTime timeOrder) {
	super();
	this.id = id;
	this.idComputer = idComputer;
	this.idCustomer = idCustomer;
	this.idTimeUserComputer = idTimeUserComputer;
	this.timeOrder = timeOrder;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdComputer() {
	return idComputer;
}
public void setIdComputer(int idComputer) {
	this.idComputer = idComputer;
}
public int getIdCustomer() {
	return idCustomer;
}
public void setIdCustomer(int idCustomer) {
	this.idCustomer = idCustomer;
}
public int getIdTimeUserComputer() {
	return idTimeUserComputer;
}
public void setIdTimeUserComputer(int idTimeUserComputer) {
	this.idTimeUserComputer = idTimeUserComputer;
}
public LocalDateTime getTimeOrder() {
	return timeOrder;
}
public void setTimeOrder(LocalDateTime timeOrder) {
	this.timeOrder = timeOrder;
}

}
