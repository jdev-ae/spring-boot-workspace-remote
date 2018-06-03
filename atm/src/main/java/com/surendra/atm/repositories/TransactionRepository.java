package com.surendra.atm.repositories;

import com.surendra.atm.model.AccountInfo;
import com.surendra.atm.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findByAccountInfoOrderByCreatedAtDesc(AccountInfo accountInfo);
}
