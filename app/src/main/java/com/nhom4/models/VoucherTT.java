package com.nhom4.models;

public class VoucherTT {
    int voucherthumb;
    String tenvoucher, hsdvoucher;
    double discount, minordervalue, vouchertoida;
    public boolean isSelected;

    public VoucherTT(int voucherthumb, String tenvoucher, String hsdvoucher, double discount, double minordervalue, double vouchertoida, boolean isSelected) {
        this.voucherthumb = voucherthumb;
        this.tenvoucher = tenvoucher;
        this.hsdvoucher = hsdvoucher;
        this.discount = discount;
        this.minordervalue = minordervalue;
        this.vouchertoida = vouchertoida;
        this.isSelected = isSelected;
    }

    public int getVoucherthumb() {
        return voucherthumb;
    }

    public void setVoucherthumb(int voucherthumb) {
        this.voucherthumb = voucherthumb;
    }

    public String getTenvoucher() {
        return tenvoucher;
    }

    public void setTenvoucher(String tenvoucher) {
        this.tenvoucher = tenvoucher;
    }

    public String getHsdvoucher() {
        return hsdvoucher;
    }

    public void setHsdvoucher(String hsdvoucher) {
        this.hsdvoucher = hsdvoucher;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMinordervalue() {
        return minordervalue;
    }

    public void setMinordervalue(double minordervalue) {
        this.minordervalue = minordervalue;
    }

    public double getVouchertoida() {
        return vouchertoida;
    }

    public void setVouchertoida(double vouchertoida) {
        this.vouchertoida = vouchertoida;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
