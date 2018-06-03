package com.surendra.atm.model.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.surendra.atm.model.Status;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterAccountResponse extends Status {

    private String userEmail;
    private String accountNumber;

    public RegisterAccountResponse() {
    }

    public RegisterAccountResponse(String userEmail, String accountNumber) {
        this.userEmail = userEmail;
        this.accountNumber = accountNumber;
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
}
