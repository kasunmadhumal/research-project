package com.research.apigatewaysimplecomplexity.controller;


import com.research.apigatewaysimplecomplexity.entity.AccountLastTransactionDto;
import com.research.apigatewaysimplecomplexity.entity.AccountLastTransactionEntity;
import com.research.apigatewaysimplecomplexity.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RestController
@RequestMapping("/account")
public class AccountController{

    @Autowired
    private AccountService accountService;

    @GetMapping("/account-last-transaction/{accountNumber}")
    public Optional<AccountLastTransactionEntity> getLastTransaction(@PathVariable String accountNumber) {
        return accountService.getLastTransaction(Long.parseLong(accountNumber));
    }

    @GetMapping("/all")
    public List<AccountLastTransactionEntity> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/account-last-transaction")
    public AccountLastTransactionEntity saveLastTransaction(@RequestBody AccountLastTransactionDto accountLastTransactionDto) {
        return accountService.saveLastTransaction(accountLastTransactionDto);
    }




}
