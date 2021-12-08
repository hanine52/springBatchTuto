package com.haben.springbatch.model;

import java.math.BigDecimal;

public class Product {

    private Integer productID;
    private String productName;

    private BigDecimal price;
    private Integer unit;
    private String ProductDesc;

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", prodName='" + productName + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                ", ProductDesc='" + ProductDesc + '\'' +
                '}';
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProdName() {
        return productName;
    }

    public void setProdName(String prodName) {
        this.productName = prodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getProductDesc() {
        return ProductDesc;
    }

    public void setProductDesc(String productDesc) {
        ProductDesc = productDesc;
    }
}
