package com.surendra.atm.model.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.surendra.atm.model.Status;
import com.surendra.atm.model.UserTransaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTransactionsResponse extends Status implements Serializable {
    private String userEmail;
    private String accountNumber;
    private BigDecimal accountBalance;
    private List<UserTransaction> transactions;

    public UserTransactionsResponse() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<UserTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<UserTransaction> transactions) {
        this.transactions = transactions;
    }
}
