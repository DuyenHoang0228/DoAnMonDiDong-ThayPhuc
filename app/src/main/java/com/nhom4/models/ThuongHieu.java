package com.nhom4.models;

public class ThuongHieu {
    int anhThuongHieu;
    String tenThuongHieu;

    public ThuongHieu(int anhThuongHieu, String tenThuongHieu) {
        this.anhThuongHieu = anhThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public int getAnhThuongHieu() {
        return anhThuongHieu;
    }

    public void setAnhThuongHieu(int anhThuongHieu) {
        this.anhThuongHieu = anhThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    @Override
    public String toString() {
        return "ThuongHieu{" +
                "anhThuongHieu=" + anhThuongHieu +
                ", tenThuongHieu='" + tenThuongHieu + '\'' +
                '}';
    }
}
