package Model;

import java.sql.Date;
import java.util.List;

public class BillHistory {
    private int idBillHistory;
    private int idCustomer;
    private int idStaff;
    private int idComputer;
    private int idPromotion;
    private Date datePaymentBill;
    private String formPaymentBill;
    private long timeUserComputer;
    private Double sumMoneyBill;
    
    public BillHistory(int idBillHistory, int idCustomer, int idStaff, int idComputer, int idPromotion,
		Date datePaymentBill, String formPaymentBill, long timeUserComputer, Double sumMoneyBill) {
		super();
		this.idBillHistory = idBillHistory;
		this.idCustomer = idCustomer;
		this.idStaff = idStaff;
		this.idComputer = idComputer;
		this.idPromotion = idPromotion;
		this.datePaymentBill = datePaymentBill;
		this.formPaymentBill = formPaymentBill;
		this.timeUserComputer = timeUserComputer;
		this.sumMoneyBill = sumMoneyBill;
	}
	public int getIdBillHistory() {
		return idBillHistory;
	}
	public void setIdBillHistory(int idBillHistory) {
		this.idBillHistory = idBillHistory;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public int getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(int idComputer) {
		this.idComputer = idComputer;
	}
	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
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
	public long getTimeUserComputer() {
		return timeUserComputer;
	}
	public void setTimeUserComputer(long timeUserComputer) {
		this.timeUserComputer = timeUserComputer;
	}
	public Double getSumMoneyBill() {
		return sumMoneyBill;
	}
	public void setSumMoneyBill(Double sumMoneyBill) {
		this.sumMoneyBill = sumMoneyBill;
	}
	private Session session;
    private Combo combo;
    private List<Order> Orders;
    // Billing functions
    public void addBillHistory() { /* logic */ }
    public void deleteBillHistory() { /* logic */ }
    public boolean checkBillHistory(String idBill) { /* logic */ return false;}
    public void checkDetailBill(String idBill) { /* logic */ }
    
    // Constructor, getters, setters
}