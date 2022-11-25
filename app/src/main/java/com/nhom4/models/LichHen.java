package com.nhom4.models;

public class LichHen {
    String dichvu, thucung, giong, coso, day, date, gio;

    public LichHen(String dichvu, String thucung, String giong, String coso, String day, String date, String gio) {
        this.dichvu = dichvu;
        this.thucung = thucung;
        this.giong = giong;
        this.coso = coso;
        this.day = day;
        this.date = date;
        this.gio = gio;
    }

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }

    public String getThucung() {
        return thucung;
    }

    public void setThucung(String thucung) {
        this.thucung = thucung;
    }

    public String getGiong() {
        return giong;
    }

    public void setGiong(String giong) {
        this.giong = giong;
    }

    public String getCoso() {
        return coso;
    }

    public void setCoso(String coso) {
        this.coso = coso;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }
}
