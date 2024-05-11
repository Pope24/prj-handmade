package com.entity;

import com.enums.EProductBrand;
import com.enums.EProductType;

import java.math.BigDecimal;

public class Product extends BaseEntity {
    private int id;
    private String name;
    private BigDecimal price;
    private int amount;
    private String description;
    private EProductType type;
    private EProductBrand brand;
    private boolean isActive;
    private User user;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price, int amount, String description, EProductType type, EProductBrand brand, boolean isActive, User user) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.brand = brand;
        this.isActive = isActive;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EProductType getType() {
        return type;
    }

    public void setType(EProductType type) {
        this.type = type;
    }

    public EProductBrand getBrand() {
        return brand;
    }

    public void setBrand(EProductBrand brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
