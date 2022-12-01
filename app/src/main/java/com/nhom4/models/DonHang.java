package com.nhom4.models;

public class DonHang {
    int hinhsanpham;
    String brandsanpham, tensanpham, tongsoluong, thanhtien;

    public DonHang(int hinhsanpham, String brandsanpham, String tensanpham, String tongsoluong, String thanhtien) {
        this.hinhsanpham = hinhsanpham;
        this.brandsanpham = brandsanpham;
        this.tensanpham = tensanpham;
        this.tongsoluong = tongsoluong;
        this.thanhtien = thanhtien;
    }

    public int getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(int hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    public String getBrandsanpham() {
        return brandsanpham;
    }

    public void setBrandsanpham(String brandsanpham) {
        this.brandsanpham = brandsanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(String tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }
}
