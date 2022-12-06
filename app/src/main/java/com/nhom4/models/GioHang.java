package com.nhom4.models;

public class GioHang {
    int idSanPham;
    String tenSanPham;
    double giaMoiSanPham;
    double giaCuSanPham;
    int idAnhSanPham;
    String loaiSanPham1;
    String thuongHieuSanPham;
    int soluongsp;
    double tongtiensp;
    boolean isSelected;

    public GioHang(int idSanPham, String tenSanPham, double giaMoiSanPham, double giaCuSanPham, int idAnhSanPham, String loaiSanPham1, String thuongHieuSanPham, int soluongsp, double tongtiensp, boolean isSelected) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.giaMoiSanPham = giaMoiSanPham;
        this.giaCuSanPham = giaCuSanPham;
        this.idAnhSanPham = idAnhSanPham;
        this.loaiSanPham1 = loaiSanPham1;
        this.thuongHieuSanPham = thuongHieuSanPham;
        this.soluongsp = soluongsp;
        this.tongtiensp = tongtiensp;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public double getTongtiensp() {
        return tongtiensp;
    }

    public void setTongtiensp(double tongtiensp) {
        this.tongtiensp = tongtiensp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
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


    public int getIdAnhSanPham() {
        return idAnhSanPham;
    }

    public void setIdAnhSanPham(int idAnhSanPham) {
        this.idAnhSanPham = idAnhSanPham;
    }

    public String getLoaiSanPham1() {
        return loaiSanPham1;
    }

    public void setLoaiSanPham1(String loaiSanPham1) {
        this.loaiSanPham1 = loaiSanPham1;
    }

    public String getThuongHieuSanPham() {
        return thuongHieuSanPham;
    }

    public void setThuongHieuSanPham(String thuongHieuSanPham) {
        this.thuongHieuSanPham = thuongHieuSanPham;
    }
}
