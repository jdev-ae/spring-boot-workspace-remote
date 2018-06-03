package com.surendra.atm.repositories;

import com.surendra.atm.model.AccountInfo;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountInfo, Long> {
    public AccountInfo findByUserEmail(String userEmail);
}
