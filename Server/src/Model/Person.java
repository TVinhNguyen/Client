package Model;

public abstract class Person {
    private String name;
    private String phone;
    private String nameAccount;
    private String passwordAccount;
    
    
	public Person(String name, String phone, String nameAccount, String passwordAccount) {
		this.name = name;
		this.phone = phone;
		this.nameAccount = nameAccount;
		this.passwordAccount = passwordAccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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

    // Constructor, getters, setters, and other common methods
}
