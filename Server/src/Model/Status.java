package Model;

public class Status {
private int id;
private int idCustomer;
private int idComputer;

public Status(int id, int idCustomer, int idComputer) {
	super();
	this.id = id;
	this.idCustomer = idCustomer;
	this.idComputer = idComputer;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdCustomer() {
	return idCustomer;
}
public void setIdCustomer(int idCustomer) {
	this.idCustomer = idCustomer;
}
public int getIdComputer() {
	return idComputer;
}
public void setIdComputer(int idComputer) {
	this.idComputer = idComputer;
}

}
