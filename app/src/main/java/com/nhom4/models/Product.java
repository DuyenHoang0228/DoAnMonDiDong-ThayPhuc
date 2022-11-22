package com.nhom4.models;

public class Product {
    int productImage;
    String productName, brandName;
    double productPrice, productPriceDiscounted;

    public Product(int productImage, String productName, String brandName, double productPrice, double productPriceDiscounted) {
        this.productImage = productImage;
        this.productName = productName;
        this.brandName = brandName;
        this.productPrice = productPrice;
        this.productPriceDiscounted = productPriceDiscounted;
    }


    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductPriceDiscounted() {
        return productPriceDiscounted;
    }

    public void setProductPriceDiscounted(double productPriceDiscounted) {
        this.productPriceDiscounted = productPriceDiscounted;
    }
}