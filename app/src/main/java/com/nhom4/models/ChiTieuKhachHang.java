package com.nhom4.models;

public class ChiTieuKhachHang {
    String userName;
    int orders;
    double spent;

    public ChiTieuKhachHang(String userName, int orders, double spent) {
        this.userName = userName;
        this.orders = orders;
        this.spent = spent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }
}
