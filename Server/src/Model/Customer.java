package Model;

public class Customer extends Person {

	private int idCustomer;
	private int pointAccount;
	private long remainTime;
	private Double remainMoney;

	public Customer(int idCustomer,String name, String phone, String nameAccount, String passwordAccount,int pointCustomer,Long remainTime, Double remainMoney) {
		super(name, phone, nameAccount, passwordAccount);
		this.idCustomer=idCustomer;
		this.pointAccount=pointCustomer;
		this.remainTime=remainTime;
		this.remainMoney=remainMoney;
	}
	
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public int getPointAccount() {
		return pointAccount;
	}
	public void setPointAccount(int pointCustomer) {
		this.pointAccount = pointCustomer;
	}
	public Long getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(Long remainTime) {
		this.remainTime = remainTime;
	}
	public Double getRemainMoney() {
		return remainMoney;
	}
	public void setRemainMoney(Double remainMoney) {
		this.remainMoney = remainMoney;
	}
	 @Override
	    public String toString() {
	        return this.getIdCustomer() + "," + this.getNameAccount() + "," + this.getPasswordAccount()+"," + this.getPointAccount() + "," + this.getRemainTime() + "," + this.getRemainMoney() ; 
	    }
	
}
