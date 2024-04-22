package com.examly.springapp.model;

import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Product {
    public Product()
    {

    }
    @Id
    private int productId;
    private String productName;
    private String productCategory;
    private String productDescription;
    private int price;
    private String priceCategory;
    public Product(int productId, String productName, String productCategory, String productDescription, int price,
            String priceCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.price = price;
        this.priceCategory = priceCategory;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getPriceCategory() {
        return priceCategory;
    }
    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }
    
    

}