package com.dto;

import java.time.LocalDate;

public class AccountDTO {
    private int id;
    private String username;
    private boolean isActive;
    private int idRole;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String identityCard;
    private LocalDate birthDay;
    private String address;
    private int gender;
    private String avatar;

    public AccountDTO(int id, String username, boolean isActive, int idRole, String fullName, String phoneNumber, String email, String identityCard, LocalDate birthDay, String address, int gender, String avatar) {
        this.id = id;
        this.username = username;
        this.isActive = isActive;
        this.idRole = idRole;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identityCard = identityCard;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.avatar = avatar;
    }

    public AccountDTO(int id, String username, boolean isActive, int idRole) {
        this.id = id;
        this.username = username;
        this.isActive = isActive;
        this.idRole = idRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
