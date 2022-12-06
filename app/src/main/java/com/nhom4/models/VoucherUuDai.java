package com.nhom4.models;

import android.widget.ImageView;

public class VoucherUuDai {

    int brandImage;
    String vouchertitle, vouchersubtitle, brandvoucher;

    public VoucherUuDai(int brandImage, String brandvoucher, String vouchertitle, String vouchersubtitle) {
        this.brandImage = brandImage;
        this.vouchertitle = vouchertitle;
        this.vouchersubtitle = vouchersubtitle;
        this.brandvoucher = brandvoucher;
    }

    public int getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(int brandImage) {
        this.brandImage = brandImage;
    }

    public String getBrandvoucher() {
        return brandvoucher;
    }

    public void setBrandvoucher(String brandvoucher) {
        this.brandvoucher = brandvoucher;
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
