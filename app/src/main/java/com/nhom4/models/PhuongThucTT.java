package com.nhom4.models;

public class PhuongThucTT {
    int iconphuongthuc;
    String tenphuongthuc, tenphuphuongthuc;

    public PhuongThucTT(int iconphuongthuc, String tenphuongthuc, String tenphuphuongthuc) {
        this.iconphuongthuc = iconphuongthuc;
        this.tenphuongthuc = tenphuongthuc;
        this.tenphuphuongthuc = tenphuphuongthuc;
    }

    public int getIconphuongthuc() {
        return iconphuongthuc;
    }

    public void setIconphuongthuc(int iconphuongthuc) {
        this.iconphuongthuc = iconphuongthuc;
    }

    public String getTenphuongthuc() {
        return tenphuongthuc;
    }

    public void setTenphuongthuc(String tenphuongthuc) {
        this.tenphuongthuc = tenphuongthuc;
    }

    public String getTenphuphuongthuc() {
        return tenphuphuongthuc;
    }

    public void setTenphuphuongthuc(String tenphuphuongthuc) {
        this.tenphuphuongthuc = tenphuphuongthuc;
    }
}
