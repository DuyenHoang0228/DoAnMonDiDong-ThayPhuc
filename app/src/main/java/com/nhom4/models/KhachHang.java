package com.nhom4.models;

import android.media.Image;

import java.util.List;

public class KhachHang {
    int avatar;
    String username, phoneNumber, emailAddress, level;
    double spend, yourSpend;
    int order, yourOrder;
    VoucherUuDai yourVoucher;
    int discount;
    DiaChi address;
    //STK ngan hang chua co
    //Còn thiếu nhiều cái


    public KhachHang(int avatar, String username, String phoneNumber, String emailAddress, String level, double spend, double yourSpend, int order, int yourOrder){
                     //VoucherUuDai yourVoucher, int discount, DiaChi address) {
        this.avatar = avatar;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.level = level;
        this.spend = spend;
        this.yourSpend = yourSpend;
        this.order = order;
        this.yourOrder = yourOrder;
//        this.yourVoucher = yourVoucher;
//        this.discount = discount;
//        this.address = address;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    public double getYourSpend() {
        return yourSpend;
    }

    public void setYourSpend(double yourSpend) {
        this.yourSpend = yourSpend;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getYourOrder() {
        return yourOrder;
    }

    public void setYourOrder(int yourOrder) {
        this.yourOrder = yourOrder;
    }

    public VoucherUuDai getYourVoucher() {
        return yourVoucher;
    }

    public void setYourVoucher(VoucherUuDai yourVoucher) {
        this.yourVoucher = yourVoucher;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public DiaChi getAddress() {
        return address;
    }

    public void setAddress(DiaChi address) {
        this.address = address;
    }
}
