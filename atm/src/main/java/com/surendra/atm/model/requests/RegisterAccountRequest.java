package com.surendra.atm.model.requests;

import java.math.BigDecimal;

public class RegisterAccountRequest {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String address;
    private BigDecimal initialBalance;

    public RegisterAccountRequest() {
    }

    public RegisterAccountRequest(String userName, String userEmail, String userPassword, String address, BigDecimal initialBalance) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.address = address;
        this.initialBalance = initialBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "RegisterAccountRequest{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", address='" + address + '\'' +
                ", initialBalance=" + initialBalance +
                '}';
    }
}
