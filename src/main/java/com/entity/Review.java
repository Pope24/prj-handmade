package com.entity;

public class Review extends BaseEntity{
    private int id;
    private String content;
    private User user;
    private Product product;

    public Review() {
    }

    public Review(int id, String content, User user, Product product) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
