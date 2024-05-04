package com.research.cacheasidesimplecomplexitynopatterns.service;

import com.research.cacheasidesimplecomplexitynopatterns.entity.AccountLastTransactionEntity;
import com.research.cacheasidesimplecomplexitynopatterns.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Optional<AccountLastTransactionEntity> getLastTransaction(Long accountNumber) {

        AccountLastTransactionEntity accountLastTransactionEntity = accountRepository.findByAccountNumber(accountNumber);

        return Optional.ofNullable(accountLastTransactionEntity);

    }

    public List<AccountLastTransactionEntity> getAll() {
        return accountRepository.findAll();
    }
}
