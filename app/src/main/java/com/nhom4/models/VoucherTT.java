package com.nhom4.models;

public class VoucherTT {
    public boolean isSelected;
    int voucherthumb;
    String tenvoucher, vouchertoida, hsdvoucher;

    public VoucherTT(int voucherthumb, String tenvoucher, String vouchertoida, String hsdvoucher, boolean isSelected) {
        this.voucherthumb = voucherthumb;
        this.tenvoucher = tenvoucher;
        this.vouchertoida = vouchertoida;
        this.hsdvoucher = hsdvoucher;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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

    public String getVouchertoida() {
        return vouchertoida;
    }

    public void setVouchertoida(String vouchertoida) {
        this.vouchertoida = vouchertoida;
    }

    public String getHsdvoucher() {
        return hsdvoucher;
    }

    public void setHsdvoucher(String hsdvoucher) {
        this.hsdvoucher = hsdvoucher;
    }
}
