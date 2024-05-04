package com.research.cacheasidesimplecomplexity.controller;

import com.research.cacheasidesimplecomplexity.entity.AccountLastTransactionEntity;
import com.research.cacheasidesimplecomplexity.service.AccountService;
import com.research.cacheasidesimplecomplexity.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Controller
@RestController
@RequestMapping("/account")
public class AccountController{

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/account-last-transaction/{accountNumber}")
    public Optional<AccountLastTransactionEntity> getLastTransaction(@PathVariable String accountNumber) {
        return accountService.getLastTransaction(Long.parseLong(accountNumber));
    }

    @GetMapping("/all")
    public List<AccountLastTransactionEntity> getAll() {
        return accountService.getAll();
    }

    @GetMapping("clear-cache")
    public void clearCache() {
        redisService.clearCache();
    }




}
