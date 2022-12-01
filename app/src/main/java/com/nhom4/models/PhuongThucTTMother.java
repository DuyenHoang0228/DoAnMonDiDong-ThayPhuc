package com.nhom4.models;

import java.util.List;

public class PhuongThucTTMother {
    List<PhuongThucTTChild> list;
    int iconphuongthuc;
    String tenphuongthuc, tenphuphuongthuc;
    public boolean isSelected;
    public boolean isExpandable;

    public PhuongThucTTMother(List<PhuongThucTTChild> list, int iconphuongthuc, String tenphuongthuc, String tenphuphuongthuc, boolean isSelected) {
        this.list = list;
        this.iconphuongthuc = iconphuongthuc;
        this.tenphuongthuc = tenphuongthuc;
        this.tenphuphuongthuc = tenphuphuongthuc;
        this.isSelected = isSelected;
        isExpandable = false;
    }

    public List<PhuongThucTTChild> getList() {
        return list;
    }

    public void setList(List<PhuongThucTTChild> list) {
        this.list = list;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
