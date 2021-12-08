package com.haben.springbatch.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.math.BigDecimal;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    private Integer productId;

    //@XmlElement(name="productName")
    private String productName;

    private BigDecimal price;
    private Integer unit;
    private String productDesc;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

    public Integer getProductID() {
        return productId;
    }

    public void setProductID(Integer productID) {
        this.productId = productID;
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
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
