package com.research.apigatewaysimplecomplexity.service;

import com.research.apigatewaysimplecomplexity.entity.AccountLastTransactionDto;
import com.research.apigatewaysimplecomplexity.entity.AccountLastTransactionEntity;
import com.research.apigatewaysimplecomplexity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public AccountLastTransactionEntity saveLastTransaction(AccountLastTransactionDto accountLastTransactionDto) {
        AccountLastTransactionEntity accountLastTransactionEntity = AccountLastTransactionEntity.builder()
                .accountNumber(accountLastTransactionDto.getAccountNumber())
                .userBalance(accountLastTransactionDto.getUserBalance())
                .lastTransaction(accountLastTransactionDto.getLastTransaction())
                .build();


        return accountRepository.save(accountLastTransactionEntity);
    }
}
