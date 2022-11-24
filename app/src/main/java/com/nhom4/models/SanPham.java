package com.nhom4.models;

public class SanPham {
    int anhSanPham;
    String tenSanPham;
    double giaMoiSanPham;
    double giaCuSanPham;
    String thuongHieu;
    String loaiSanPham;
    String looaiSanPham2;

    public SanPham(int anhSanPham, String tenSanPham, double giaMoiSanPham, double giaCuSanPham, String thuongHieu, String loaiSanPham, String looaiSanPham2) {
        this.anhSanPham = anhSanPham;
        this.tenSanPham = tenSanPham;
        this.giaMoiSanPham = giaMoiSanPham;
        this.giaCuSanPham = giaCuSanPham;
        this.thuongHieu = thuongHieu;
        this.loaiSanPham = loaiSanPham;
        this.looaiSanPham2 = looaiSanPham2;
    }

    public int getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(int anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaMoiSanPham() {
        return giaMoiSanPham;
    }

    public void setGiaMoiSanPham(double giaMoiSanPham) {
        this.giaMoiSanPham = giaMoiSanPham;
    }

    public double getGiaCuSanPham() {
        return giaCuSanPham;
    }

    public void setGiaCuSanPham(double giaCuSanPham) {
        this.giaCuSanPham = giaCuSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getLooaiSanPham2() {
        return looaiSanPham2;
    }

    public void setLooaiSanPham2(String looaiSanPham2) {
        this.looaiSanPham2 = looaiSanPham2;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "anhSanPham=" + anhSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaMoiSanPham=" + giaMoiSanPham +
                ", giaCuSanPham=" + giaCuSanPham +
                ", thuongHieu='" + thuongHieu + '\'' +
                ", loaiSanPham='" + loaiSanPham + '\'' +
                ", looaiSanPham2='" + looaiSanPham2 + '\'' +
                '}';
    }
}