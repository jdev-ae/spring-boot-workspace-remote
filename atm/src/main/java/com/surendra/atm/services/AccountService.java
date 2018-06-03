package com.surendra.atm.services;

import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.model.requests.RegisterAccountRequest;
import com.surendra.atm.model.responses.AccountBalanceResponse;
import com.surendra.atm.model.responses.AccountInfoResponse;
import com.surendra.atm.model.responses.RegisterAccountResponse;
import com.surendra.atm.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    RegisterAccountResponse registerNewAccount(RegisterAccountRequest request) throws TransactionException;

    AccountBalanceResponse getAccountBalance(String accountNumber);

    AccountInfoResponse getAccountInfo(String accountNumber);
}
