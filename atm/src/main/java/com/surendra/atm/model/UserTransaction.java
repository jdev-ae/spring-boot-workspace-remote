package com.surendra.atm.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserTransaction implements Serializable {
    private String description;
    private BigDecimal amount;
    private String date;

    public UserTransaction() {
    }

    public UserTransaction(String description, BigDecimal amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
