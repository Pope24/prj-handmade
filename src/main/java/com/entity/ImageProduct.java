package com.entity;

public class ImageProduct {
    private int id;
    private String linkImage;
    private int idProduct;

    public ImageProduct() {
    }

    public ImageProduct(int id, String linkImage, int idProduct) {
        this.id = id;
        this.linkImage = linkImage;
        this.idProduct = idProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
