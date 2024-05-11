package com.entity;

import java.time.LocalDateTime;

public class Voucher extends BaseEntity{
    private int id;
    private String name;
    private LocalDateTime effectiveTo;
    private LocalDateTime effectiveFrom;
    private int percent;
    private String content;
    private int quantity;

    public Voucher() {
    }

    public Voucher(int id, String name, LocalDateTime effectiveTo, LocalDateTime effectiveFrom, int percent, String content, int quantity) {
        this.id = id;
        this.name = name;
        this.effectiveTo = effectiveTo;
        this.effectiveFrom = effectiveFrom;
        this.percent = percent;
        this.content = content;
        this.quantity = quantity;
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

    public LocalDateTime getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(LocalDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public LocalDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
