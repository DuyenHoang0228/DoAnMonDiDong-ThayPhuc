package com.nhom4.models;

public class VoucherUuDai {

    String vouchertitle, vouchersubtitle;

    public VoucherUuDai(String vouchertitle, String vouchersubtitle) {

        this.vouchertitle = vouchertitle;
        this.vouchersubtitle = vouchersubtitle;
    }



    public String getVouchertitle() {
        return vouchertitle;
    }

    public void setVouchertitle(String vouchertitle) {
        this.vouchertitle = vouchertitle;
    }

    public String getVouchersubtitle() {
        return vouchersubtitle;
    }

    public void setVouchersubtitle(String vouchersubtitle) {
        this.vouchersubtitle = vouchersubtitle;
    }
}
