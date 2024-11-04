package Model;

import java.sql.Date;
import java.sql.Time;

public class Staff extends Person {
    private int idStaff;
    private String addressStaff;
    private Date timeStartWork;
    private String role;
    private int dayWork;
    

    public void addMoneyToAccount(UserAccount customer, double amount) { /* logic */ }
    public void toggleComputer(Computer computer, boolean on) { /* logic */ }
    public void timeKeeping() { /* logic */ }
    public void serveCustomer() { /* logic */ }
    
    public Staff(String name, String phone, String nameAccount, String passwordAccount) {
        super(name, phone, nameAccount, passwordAccount);
        
    }
    public Staff(String name, String phone, String nameAccount, String passwordAccount, 
    		 String role,String addressStaff, Date timeStartWork, int dayWork) {
   super(name, phone, nameAccount, passwordAccount);
   this.addressStaff = addressStaff;
   this.timeStartWork = timeStartWork;
   this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
    
}
