package com.nhom4.models;

public class DanhGiaSanPhamM {
    int avatar;
    String userName;
    int pawRate;
    String feedback;
    int imvFeedbackImage1, imvFeedbackImage2, imvFeedbackImage3;
    //Cái dưới này phải là ngày tháng nhưng chưa biết xài
    String dateOfFeedback;
    //Phải thêm id của sản phẩm nữa


    public DanhGiaSanPhamM(int avatar, String userName, int pawRate, String feedback, int imvFeedbackImage1, int imvFeedbackImage2, int imvFeedbackImage3, String dateOfFeedback) {
        this.avatar = avatar;
        this.userName = userName;
        this.pawRate = pawRate;
        this.feedback = feedback;
        this.imvFeedbackImage1 = imvFeedbackImage1;
        this.imvFeedbackImage2 = imvFeedbackImage2;
        this.imvFeedbackImage3 = imvFeedbackImage3;
        this.dateOfFeedback = dateOfFeedback;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getImvFeedbackImage1() {
        return imvFeedbackImage1;
    }

    public void setImvFeedbackImage1(int imvFeedbackImage1) {
        this.imvFeedbackImage1 = imvFeedbackImage1;
    }

    public int getImvFeedbackImage2() {
        return imvFeedbackImage2;
    }

    public void setImvFeedbackImage2(int imvFeedbackImage2) {
        this.imvFeedbackImage2 = imvFeedbackImage2;
    }

    public int getImvFeedbackImage3() {
        return imvFeedbackImage3;
    }

    public void setImvFeedbackImage3(int imvFeedbackImage3) {
        this.imvFeedbackImage3 = imvFeedbackImage3;
    }

    public String getDateOfFeedback() {
        return dateOfFeedback;
    }

    public void setDateOfFeedback(String dateOfFeedback) {
        this.dateOfFeedback =dateOfFeedback;
    }

    public int getPawRate() {
        return pawRate;
    }

    public void setPawRate(int pawRate) {
        this.pawRate = pawRate;
    }
}
