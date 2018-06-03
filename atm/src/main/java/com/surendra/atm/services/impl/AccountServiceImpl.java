package com.surendra.atm.services.impl;

import com.surendra.atm.enums.TransactionType;
import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.model.AccountInfo;
import com.surendra.atm.model.Transaction;
import com.surendra.atm.model.requests.RegisterAccountRequest;
import com.surendra.atm.model.requests.TransactionRequest;
import com.surendra.atm.model.responses.AccountBalanceResponse;
import com.surendra.atm.model.responses.AccountInfoResponse;
import com.surendra.atm.model.responses.RegisterAccountResponse;
import com.surendra.atm.repositories.AccountRepository;
import com.surendra.atm.services.AccountService;
import com.surendra.atm.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

import static com.surendra.atm.Constants.STATUS_SUCCESS;

@Component
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private TransactionService transactionService;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.transactionService = transactionService;
    }

    @Override
    public RegisterAccountResponse registerNewAccount(RegisterAccountRequest request) throws TransactionException {
        if (request.getInitialBalance().compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransactionException("initial balance should be greater than zero");
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNumber(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
        accountInfo.setAccountPassword(passwordEncoder.encode(request.getUserPassword()));
        accountInfo.setAddress(request.getAddress());
        accountInfo.setBalance(request.getInitialBalance());
        accountInfo.setUserEmail(request.getUserEmail());
        accountInfo.setUserName(request.getUserName());
        AccountInfo save = accountRepository.save(accountInfo);

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setTransactionType(TransactionType.DEPOSIT);
        transactionRequest.setAmount(request.getInitialBalance());
        transactionRequest.setDescription("opening balance");
        transactionService.makeTransaction(transactionRequest, request.getUserEmail());

        RegisterAccountResponse registerAccountResponse = new RegisterAccountResponse(save.getUserEmail(), save.getAccountNumber());
        registerAccountResponse.setStatus(STATUS_SUCCESS);

        return registerAccountResponse;
    }

    @Override
    public AccountBalanceResponse getAccountBalance(String userEmail) {
        AccountInfo accountInfo = accountRepository.findByUserEmail(userEmail);
        return new AccountBalanceResponse(accountInfo.getAccountNumber(), accountInfo.getUserEmail(), accountInfo.getBalance());
    }

    @Override
    public AccountInfoResponse getAccountInfo(String userEmail) {
        AccountInfo accountInfo = accountRepository.findByUserEmail(userEmail);
        AccountInfoResponse response = new AccountInfoResponse();
        response.setAccountNumber(accountInfo.getAccountNumber());
        response.setBalance(accountInfo.getBalance());
        response.setUserEmail(accountInfo.getUserEmail());
        response.setUserName(accountInfo.getUserName());
        return response;
    }
}
