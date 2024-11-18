package Model;

public class TimeUserComputer {
private int idUserComputer;
private long timeUser;
private Double moneyUser;

public TimeUserComputer(int idUserComputer, long timeUser, Double moneyUser) {
	super();
	this.idUserComputer = idUserComputer;
	this.timeUser = timeUser;
	this.moneyUser = moneyUser;
}
public int getIdUserComputer() {
	return idUserComputer;
}
public void setIdUserComputer(int idUserComputer) {
	this.idUserComputer = idUserComputer;
}
public long getTimeUser() {
	return timeUser;
}
public void setTimeUser(long timeUser) {
	this.timeUser = timeUser;
}
public Double getMoneyUser() {
	return moneyUser;
}
public void setMoneyUser(Double moneyUser) {
	this.moneyUser = moneyUser;
}

}
