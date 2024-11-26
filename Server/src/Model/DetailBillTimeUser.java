package Model;

public class DetailBillTimeUser {
private int id;
private int idBillHistory;
private int idTimeUserComputer;

public DetailBillTimeUser(int id, int idBillHistory, int idTimeUserComputer) {
	super();
	this.id = id;
	this.idBillHistory = idBillHistory;
	this.idTimeUserComputer = idTimeUserComputer;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdBillHistory() {
	return idBillHistory;
}
public void setIdBillHistory(int idBillHistory) {
	this.idBillHistory = idBillHistory;
}
public int getIdTimeUserComputer() {
	return idTimeUserComputer;
}
public void setIdTimeUserComputer(int idTimeUserComputer) {
	this.idTimeUserComputer = idTimeUserComputer;
}

}
