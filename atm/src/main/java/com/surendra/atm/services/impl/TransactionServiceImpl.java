package com.surendra.atm.services.impl;

import com.surendra.atm.Constants;
import com.surendra.atm.exceptions.TransactionException;
import com.surendra.atm.model.AccountInfo;
import com.surendra.atm.model.Status;
import com.surendra.atm.model.StatusFactory;
import com.surendra.atm.model.Transaction;
import com.surendra.atm.model.UserTransaction;
import com.surendra.atm.model.requests.TransactionRequest;
import com.surendra.atm.model.responses.UserTransactionsResponse;
import com.surendra.atm.repositories.AccountRepository;
import com.surendra.atm.repositories.TransactionRepository;
import com.surendra.atm.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl implements TransactionService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public Status makeTransaction(TransactionRequest request, String fromAccountEmail) throws TransactionException {
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw new TransactionException("Invalid amount to do a transaction: " + request.getAmount());
        AccountInfo fromAccount = accountRepository.findByUserEmail(fromAccountEmail);
        Transaction transaction = new Transaction();
        transaction.setAccountInfo(fromAccount);
        BigDecimal fromAccountBalance = fromAccount.getBalance();
        switch (request.getTransactionType()) {
            case DEPOSIT:
                transaction.setAmount(request.getAmount());
                transaction.setDescription(request.getDescription());
                try {
                    transactionRepository.save(transaction);
                    fromAccount.setBalance(fromAccountBalance.add(request.getAmount()));
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new TransactionException("Failed to do transaction");
                }
                return successStatus("deposit success");
            case WITHDRAW:
                BigDecimal finalAmount = fromAccountBalance.subtract(request.getAmount());
                if (finalAmount.compareTo(BigDecimal.ZERO) < 0) {
                    throw new TransactionException("Insufficient balance to withdraw");
                }
                transaction.setAmount(BigDecimal.ZERO.subtract(request.getAmount()));
                transaction.setDescription(request.getDescription());
                try {
                    transactionRepository.save(transaction);
                    fromAccount.setBalance(finalAmount);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new TransactionException("Failed to do transaction");
                }
                return successStatus("withdraw success");
            case TRANSFER:
                AccountInfo toAccount = accountRepository.findByUserEmail(request.getToAccountEmail());
                if (toAccount == null) {
                    throw new TransactionException("Failed to do transaction, account not found: " + request.getToAccountEmail());
                }
                BigDecimal finalFromAccountAmount = fromAccountBalance.subtract(request.getAmount());
                if (finalFromAccountAmount.compareTo(BigDecimal.ZERO) < 0) {
                    throw new TransactionException("Insufficient balance to transfer");
                }
                try {
                    transaction.setDescription("transfer to " + toAccount.getUserEmail()
                            + (StringUtils.isEmpty(request.getDescription()) ? "" : " for " + request.getDescription()));
                    transaction.setAmount(BigDecimal.ZERO.subtract(request.getAmount()));
                    transactionRepository.save(transaction);
                    Transaction toTransaction = new Transaction();
                    toTransaction.setAmount(request.getAmount());
                    toTransaction.setDescription("transfer from " + fromAccountEmail
                            + (StringUtils.isEmpty(request.getDescription()) ? "" : " for " + request.getDescription()));
                    toTransaction.setAccountInfo(toAccount);
                    transactionRepository.save(toTransaction);
                    toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));
                    fromAccount.setBalance(finalFromAccountAmount);
                    return successStatus("transfer success");
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new TransactionException("Failed to do transaction");
                }
        }
        throw new TransactionException("something went wrong");
    }

    @Override
    public UserTransactionsResponse getUserTransactions(String accountEmail) {
        AccountInfo accountInfo = accountRepository.findByUserEmail(accountEmail);
        List<Transaction> transactions = transactionRepository.findByAccountInfoOrderByCreatedAtDesc(accountInfo);
        UserTransactionsResponse response = new UserTransactionsResponse();
        response.setAccountNumber(accountInfo.getAccountNumber());
        response.setUserEmail(accountEmail);
        response.setAccountBalance(accountInfo.getBalance());
        List<UserTransaction> userTransactions = new ArrayList<>();
        userTransactions.addAll(transactions.stream()
                .map(t -> new UserTransaction(t.getDescription(), t.getAmount(), Constants.DATE_FORMAT.format(t.getCreatedAt())))
                .collect(Collectors.toList()));
        response.setTransactions(userTransactions);
        response.setStatus(Constants.STATUS_SUCCESS);
        return response;
    }

    public Status successStatus(String message) {
        Status successStatus = StatusFactory.getSuccessStatus();
        successStatus.setStatusMessage(message);
        return successStatus;
    }
}
