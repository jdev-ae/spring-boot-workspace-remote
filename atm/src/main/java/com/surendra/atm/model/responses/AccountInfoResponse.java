package com.surendra.atm.model.responses;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountInfoResponse implements Serializable {
    private String accountNumber;
    private String userName;
    private String userEmail;
    private BigDecimal balance;

    public AccountInfoResponse() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
