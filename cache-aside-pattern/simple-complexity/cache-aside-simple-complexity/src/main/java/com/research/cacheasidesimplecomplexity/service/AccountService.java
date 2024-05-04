package com.research.cacheasidesimplecomplexity.service;

import com.research.cacheasidesimplecomplexity.entity.AccountLastTransactionEntity;
import com.research.cacheasidesimplecomplexity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Cacheable(value = "AccountLastTransaction", key = "#accountNumber")
    public Optional<AccountLastTransactionEntity> getLastTransaction(Long accountNumber) {

        AccountLastTransactionEntity accountLastTransactionEntity = accountRepository.findByAccountNumber(accountNumber);

        return Optional.ofNullable(accountLastTransactionEntity);

    }

    @Cacheable(value = "AccountLastTransaction")
    public List<AccountLastTransactionEntity> getAll() {
        return accountRepository.findAll();
    }

}
