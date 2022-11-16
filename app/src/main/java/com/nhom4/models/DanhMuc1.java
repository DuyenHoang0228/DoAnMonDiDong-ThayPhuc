package com.nhom4.models;

public class DanhMuc1 {
    int danhmucThumb ;
    String danhmucName;

    public DanhMuc1(int danhmucThumb, String danhmucName) {
        this.danhmucThumb = danhmucThumb;
        this.danhmucName = danhmucName;
    }

    public int getDanhmucThumb() {
        return danhmucThumb;
    }

    public void setDanhmucThumb(int danhmucThumb) {
        this.danhmucThumb = danhmucThumb;
    }

    public String getDanhmucName() {
        return danhmucName;
    }

    public void setDanhmucName(String danhmucName) {
        this.danhmucName = danhmucName;
    }
}
