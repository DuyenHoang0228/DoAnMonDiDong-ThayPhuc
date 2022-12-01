package com.nhom4.models;

public class SanPhamLilPawHome {

    int idSanPham;
    String tenSanPham;
    double giaMoiSanPham;
    double giaCuSanPham;
    double giamGiaSanPham;
    String idAnhSanPham;
    String loaiSanPham1;
    String loaiSanPham2;
    String loaiSanPham3;
    String thuongHieuSanPham;
    String moTaSanPham;
    double saoDanhGiaSP;
    double luotMuaSP;
    double luotDanhGiaSP;

    public SanPhamLilPawHome(int idSanPham, String tenSanPham, double giaMoiSanPham, double giaCuSanPham, double giamGiaSanPham, String idAnhSanPham, String loaiSanPham1, String loaiSanPham2, String loaiSanPham3, String thuongHieuSanPham, String moTaSanPham, double saoDanhGiaSP, double luotMuaSP, double luotDanhGiaSP) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.giaMoiSanPham = giaMoiSanPham;
        this.giaCuSanPham = giaCuSanPham;
        this.giamGiaSanPham = giamGiaSanPham;
        this.idAnhSanPham = idAnhSanPham;
        this.loaiSanPham1 = loaiSanPham1;
        this.loaiSanPham2 = loaiSanPham2;
        this.loaiSanPham3 = loaiSanPham3;
        this.thuongHieuSanPham = thuongHieuSanPham;
        this.moTaSanPham = moTaSanPham;
        this.saoDanhGiaSP = saoDanhGiaSP;
        this.luotMuaSP = luotMuaSP;
        this.luotDanhGiaSP = luotDanhGiaSP;
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

    public double getGiamGiaSanPham() {
        return giamGiaSanPham;
    }

    public void setGiamGiaSanPham(double giamGiaSanPham) {
        this.giamGiaSanPham = giamGiaSanPham;
    }

    public String getIdAnhSanPham() {
        return idAnhSanPham;
    }

    public void setIdAnhSanPham(String idAnhSanPham) {
        this.idAnhSanPham = idAnhSanPham;
    }

    public String getLoaiSanPham1() {
        return loaiSanPham1;
    }

    public void setLoaiSanPham1(String loaiSanPham1) {
        this.loaiSanPham1 = loaiSanPham1;
    }

    public String getLoaiSanPham2() {
        return loaiSanPham2;
    }

    public void setLoaiSanPham2(String loaiSanPham2) {
        this.loaiSanPham2 = loaiSanPham2;
    }

    public String getLoaiSanPham3() {
        return loaiSanPham3;
    }

    public void setLoaiSanPham3(String loaiSanPham3) {
        this.loaiSanPham3 = loaiSanPham3;
    }

    public String getThuongHieuSanPham() {
        return thuongHieuSanPham;
    }

    public void setThuongHieuSanPham(String thuongHieuSanPham) {
        this.thuongHieuSanPham = thuongHieuSanPham;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public double getSaoDanhGiaSP() {
        return saoDanhGiaSP;
    }

    public void setSaoDanhGiaSP(double saoDanhGiaSP) {
        this.saoDanhGiaSP = saoDanhGiaSP;
    }

    public double getLuotMuaSP() {
        return luotMuaSP;
    }

    public void setLuotMuaSP(double luotMuaSP) {
        this.luotMuaSP = luotMuaSP;
    }

    public double getLuotDanhGiaSP() {
        return luotDanhGiaSP;
    }

    public void setLuotDanhGiaSP(double luotDanhGiaSP) {
        this.luotDanhGiaSP = luotDanhGiaSP;
    }

    @Override
    public String toString() {
        return "SanPhamLilPawHome{" +
                "idSanPham=" + idSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaMoiSanPham=" + giaMoiSanPham +
                ", giaCuSanPham=" + giaCuSanPham +
                ", giamGiaSanPham=" + giamGiaSanPham +
                ", idAnhSanPham='" + idAnhSanPham + '\'' +
                ", loaiSanPham1='" + loaiSanPham1 + '\'' +
                ", loaiSanPham2='" + loaiSanPham2 + '\'' +
                ", loaiSanPham3='" + loaiSanPham3 + '\'' +
                ", thuongHieuSanPham='" + thuongHieuSanPham + '\'' +
                ", moTaSanPham='" + moTaSanPham + '\'' +
                ", saoDanhGiaSP=" + saoDanhGiaSP +
                ", luotMuaSP=" + luotMuaSP +
                ", luotDanhGiaSP=" + luotDanhGiaSP +
                '}';
    }
}
