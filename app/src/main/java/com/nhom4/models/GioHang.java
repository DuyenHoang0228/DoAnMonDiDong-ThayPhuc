package com.nhom4.models;

public class GioHang {
    int hinhsanpham, soluongsp;
    String brandsanpham, tensanpham, phanloaishop;
    Double giasanphamdagiam, giasanphamchuagiam;

    public GioHang(int hinhsanpham, int soluongsp, String brandsanpham, String tensanpham, String phanloaishop, Double giasanphamdagiam, Double giasanphamchuagiam) {
        this.hinhsanpham = hinhsanpham;
        this.soluongsp = soluongsp;
        this.brandsanpham = brandsanpham;
        this.tensanpham = tensanpham;
        this.phanloaishop = phanloaishop;
        this.giasanphamdagiam = giasanphamdagiam;
        this.giasanphamchuagiam = giasanphamchuagiam;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
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

    public String getPhanloaishop() {
        return phanloaishop;
    }

    public void setPhanloaishop(String phanloaishop) {
        this.phanloaishop = phanloaishop;
    }

    public Double getGiasanphamdagiam() {
        return giasanphamdagiam;
    }

    public void setGiasanphamdagiam(Double giasanphamdagiam) {
        this.giasanphamdagiam = giasanphamdagiam;
    }

    public Double getGiasanphamchuagiam() {
        return giasanphamchuagiam;
    }

    public void setGiasanphamchuagiam(Double giasanphamchuagiam) {
        this.giasanphamchuagiam = giasanphamchuagiam;
    }
}
