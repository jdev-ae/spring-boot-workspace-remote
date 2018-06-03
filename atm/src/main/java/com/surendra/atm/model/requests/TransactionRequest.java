package com.surendra.atm.model.requests;

import com.surendra.atm.enums.TransactionType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;


public class TransactionRequest implements Serializable {
    private BigDecimal amount;
    private String toAccountEmail;
    @ApiModelProperty(hidden = true)
    private TransactionType transactionType;
    private String description;

    public TransactionRequest() {
    }

    public TransactionRequest(BigDecimal amount, String toAccountEmail, TransactionType transactionType, String description) {
        this.amount = amount;
        this.toAccountEmail = toAccountEmail;
        this.transactionType = transactionType;
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getToAccountEmail() {
        return toAccountEmail;
    }

    public void setToAccountEmail(String toAccountEmail) {
        this.toAccountEmail = toAccountEmail;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
