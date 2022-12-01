package com.nhom4.models;

public class Voucher {
    String titleOfVoucher, hsdVoucher, chuTrongAnhVoucher;
    int maxValue;
    boolean limited;

    public Voucher(String titleOfVoucher, String hsdVoucher, int maxValue, String chuTrongAnhVoucher, boolean limited) {
        this.titleOfVoucher = titleOfVoucher;
        this.hsdVoucher = hsdVoucher;
        this.chuTrongAnhVoucher = chuTrongAnhVoucher;
        this.maxValue = maxValue;
        this.limited = limited;
    }

    public String getTitleOfVoucher() {
        return titleOfVoucher;
    }

    public void setTitleOfVoucher(String titleOfVoucher) {
        this.titleOfVoucher = titleOfVoucher;
    }

    public String getHsdVoucher() {
        return hsdVoucher;
    }

    public void setHsdVoucher(String hsdVoucher) {
        this.hsdVoucher = hsdVoucher;
    }

    public String getChuTrongAnhVoucher() {
        return chuTrongAnhVoucher;
    }

    public void setChuTrongAnhVoucher(String chuTrongAnhVoucher) {
        this.chuTrongAnhVoucher = chuTrongAnhVoucher;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isLimited() {
        return limited;
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }
}
