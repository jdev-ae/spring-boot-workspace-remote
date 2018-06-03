package com.surendra.atm.services;

import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.model.Status;
import com.surendra.atm.model.requests.TransactionRequest;
import com.surendra.atm.model.responses.UserTransactionsResponse;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Status makeTransaction(TransactionRequest request, String fromAccountEmail) throws TransactionException;

    UserTransactionsResponse getUserTransactions(String accountEmail);
}
