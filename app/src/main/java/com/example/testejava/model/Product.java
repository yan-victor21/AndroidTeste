package com.example.testejava.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private Integer quantity;
    private Integer stock;
    private Long price;
    private String image_url;
    private Integer tax;
    private Integer shipping;
    private String description;

    public Product(String name, Integer quantity, Integer stock, Long price, String image_url, Integer tax, Integer shipping, String description){
        this.name = name;
        this.quantity = quantity;
        this.stock = stock;
        this.price = price;
        this.image_url = image_url;
        this.tax = tax;
        this.shipping =shipping;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", stock=" + stock +
                ", price=" + price +
                ", image_url='" + image_url + '\'' +
                ", tax=" + tax +
                ", shipping=" + shipping +
                ", description='" + description + '\'' +
                '}';
    }
}
