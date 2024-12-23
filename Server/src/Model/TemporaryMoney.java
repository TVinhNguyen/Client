package Model;

import java.time.LocalDateTime;

public class TemporaryMoney {
    private int idTemporaryMoney;      // ID tạm thời, khóa chính
    private int idComputer;           // ID khách hàng, khóa phụ
    private LocalDateTime timeOrder;  // Thời gian đặt hàng
    private double money;             // Số tiền

    // Constructor
    public TemporaryMoney(int idTemporaryMoney, int idComputer, LocalDateTime timeOrder, double money) {
        this.idTemporaryMoney = idTemporaryMoney;
        this.idComputer = idComputer;
        this.timeOrder = timeOrder;
        this.money = money;
    }

    // Getters and Setters
    public int getIdTemporaryMoney() {
        return idTemporaryMoney;
    }

    public void setIdTemporaryMoney(int idTemporaryMoney) {
        this.idTemporaryMoney = idTemporaryMoney;
    }

    public int getidComputer() {
        return idComputer;
    }

    public void setidComputer(int idComputer) {
        this.idComputer = idComputer;
    }

    public LocalDateTime getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(LocalDateTime timeOrder) {
        this.timeOrder = timeOrder;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}