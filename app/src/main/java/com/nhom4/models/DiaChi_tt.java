package com.nhom4.models;

import android.widget.RadioButton;

public class DiaChi_tt {
    String tennguoinhan, sodienthoai, diachinguoinhan;
    public boolean isSelected, macdinh;

    public DiaChi_tt(String tennguoinhan, String sodienthoai, String diachinguoinhan, boolean isSelected, boolean macdinh) {
        this.tennguoinhan = tennguoinhan;
        this.sodienthoai = sodienthoai;
        this.diachinguoinhan = diachinguoinhan;
        this.isSelected = isSelected;
        this.macdinh = macdinh;
    }

    public boolean isMacdinh() {
        return macdinh;
    }

    public void setMacdinh(boolean macdinh) {
        this.macdinh = macdinh;
    }

    public String getTennguoinhan() {
        return tennguoinhan;
    }

    public void setTennguoinhan(String tennguoinhan) {
        this.tennguoinhan = tennguoinhan;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachinguoinhan() {
        return diachinguoinhan;
    }

    public void setDiachinguoinhan(String diachinguoinhan) {
        this.diachinguoinhan = diachinguoinhan;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
