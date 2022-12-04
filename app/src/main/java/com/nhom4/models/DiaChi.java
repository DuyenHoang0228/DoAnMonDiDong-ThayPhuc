package com.nhom4.models;

public class DiaChi {
    String ten, sdt, diachi;

    public DiaChi(String ten, String sdt, String diachi) {
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
