package com.surendra.atm.model.responses;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountBalanceResponse implements Serializable {
    private String accountNumber;
    private String userEmail;
    private BigDecimal accountBalance;

    public AccountBalanceResponse() {
    }

    public AccountBalanceResponse(String accountNumber, String userEmail, BigDecimal accountBalance) {
        this.accountNumber = accountNumber;
        this.userEmail = userEmail;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
