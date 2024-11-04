package Model;

import java.time.LocalDateTime;
import java.util.List;

public class BillHistory {
    private String idBill;
    private Session session;
    private LocalDateTime  datePaymentBill;
    private Combo combo;
    private List<Order> Orders;
    // Billing functions
    public void addBillHistory() { /* logic */ }
    public void deleteBillHistory() { /* logic */ }
    public boolean checkBillHistory(String idBill) { /* logic */ return false;}
    public void checkDetailBill(String idBill) { /* logic */ }
    
    // Constructor, getters, setters
}