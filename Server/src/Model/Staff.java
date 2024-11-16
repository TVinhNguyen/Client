package Model;

import java.sql.Date;


public class Staff extends Person {
    private int idStaff;
    private String addressStaff;
    private Date timeStartWork;
    private int dayWork;
    private int idRole;
    
	public void addMoneyToAccount(UserAccount customer, double amount) { /* logic */ }
    public void toggleComputer(Computer computer, boolean on) { /* logic */ }
    public void timeKeeping() { /* logic */ }
    public void serveCustomer() { /* logic */ }
    public Staff(int idStaff,String name, String phone, String nameAccount, String passwordAccount, 
    		String addressStaff, Date timeStartWork, int dayWork,int idRole) {
   super(name, phone, nameAccount, passwordAccount);
   this.idStaff=idStaff;
   this.addressStaff = addressStaff;
   this.timeStartWork = timeStartWork;
   this.idRole = idRole;
   this.dayWork = dayWork;
}
   
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	
	public String getAddressStaff() {
		return addressStaff;
	}
	public void setAddressStaff(String addressStaff) {
		this.addressStaff = addressStaff;
	}
	public Date getTimeStartWork() {
		return timeStartWork;
	}
	public void setTimeStartWork(Date timeStartWork) {
		this.timeStartWork = timeStartWork;
	}
	public int getDayWork() {
		return dayWork;
	}
	public void setDayWork(int dayWork) {
		this.dayWork = dayWork;
	}
    public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}    
}
