package com.entity;

import com.enums.EOrderStatus;
import com.enums.EPaymentStatus;

import java.math.BigDecimal;

public class Order extends BaseEntity{
    private int id;
    private EOrderStatus orderStatus;
    private EPaymentStatus paymentStatus;
    private BigDecimal totalMoney;
    private String city;
    private String district;
    private String ward;
    private String apartmentNumber;
    private String note;
    private User user;
    private Voucher voucher;

    public Order() {
    }

    public Order(int id, EOrderStatus orderStatus, EPaymentStatus paymentStatus, BigDecimal totalMoney, String city, String district, String ward, String apartmentNumber, String note, User user, Voucher voucher) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.totalMoney = totalMoney;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.apartmentNumber = apartmentNumber;
        this.note = note;
        this.user = user;
        this.voucher = voucher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public EPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(EPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
