package com.nhom4.models;

import android.widget.RadioButton;

public class PhuongThucTT {
    int iconphuongthuc;
    String tenphuongthuc, tenphuphuongthuc;
    public boolean isSelected;


    public PhuongThucTT(int iconphuongthuc, String tenphuongthuc, String tenphuphuongthuc, boolean isSelected) {
        this.iconphuongthuc = iconphuongthuc;
        this.tenphuongthuc = tenphuongthuc;
        this.tenphuphuongthuc = tenphuphuongthuc;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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
