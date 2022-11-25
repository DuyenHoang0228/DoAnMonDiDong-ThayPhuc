package com.nhom4.models;

public class ThongBao {
    int thongbaoIcon ;
    String thongbaoTittle;
    String thongbaoContent;

    public ThongBao(int thongbaoIcon, String thongbaoTittle, String thongbaoContent) {
        this.thongbaoIcon = thongbaoIcon;
        this.thongbaoTittle = thongbaoTittle;
        this.thongbaoContent = thongbaoContent;
    }

    public int getThongbaoIcon() {
        return thongbaoIcon;
    }

    public void setThongbaoIcon(int thongbaoIcon) {
        this.thongbaoIcon = thongbaoIcon;
    }

    public String getThongbaoTittle() {
        return thongbaoTittle;
    }

    public void setThongbaoTittle(String thongbaoTittle) {
        this.thongbaoTittle = thongbaoTittle;
    }

    public String getThongbaoContent() {
        return thongbaoContent;
    }

    public void setThongbaoContent(String thongbaoContent) {
        this.thongbaoContent = thongbaoContent;
    }


}
