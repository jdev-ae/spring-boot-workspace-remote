package com.surendra.atm.exceptions;

public class TransactionException extends Exception {
    private String reason;

    public TransactionException(String reason) {
        super(reason);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
