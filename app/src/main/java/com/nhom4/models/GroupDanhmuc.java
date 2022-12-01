package com.nhom4.models;

public class GroupDanhmuc {
    int danhmucThumb,danhmucID ;
    String danhmucName;

    public int getDanhmucThumb() {
        return danhmucThumb;
    }

    public void setDanhmucThumb(int danhmucThumb) {
        this.danhmucThumb = danhmucThumb;
    }

    public int getDanhmucID() {
        return danhmucID;
    }

    public void setDanhmucID(int danhmucID) {
        this.danhmucID = danhmucID;
    }

    public String getDanhmucName() {
        return danhmucName;
    }

    public void setDanhmucName(String danhmucName) {
        this.danhmucName = danhmucName;
    }

    public GroupDanhmuc(int danhmucThumb, int danhmucID, String danhmucName) {
        this.danhmucThumb = danhmucThumb;
        this.danhmucID = danhmucID;
        this.danhmucName = danhmucName;
    }
}
