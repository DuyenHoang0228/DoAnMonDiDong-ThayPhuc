package com.nhom4.models;

public class DiaChi_tt {
    String tennguoinhan, sodienthoai, diachinguoinhan;

    public DiaChi_tt(String tennguoinhan, String sodienthoai, String diachinguoinhan) {
        this.tennguoinhan = tennguoinhan;
        this.sodienthoai = sodienthoai;
        this.diachinguoinhan = diachinguoinhan;
    }

    public String getTennguoinhan() {
        return tennguoinhan;
    }

    public void setTennguoinhan(String tennguoinhan) {
        this.tennguoinhan = tennguoinhan;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachinguoinhan() {
        return diachinguoinhan;
    }

    public void setDiachinguoinhan(String diachinguoinhan) {
        this.diachinguoinhan = diachinguoinhan;
    }
}
