package com.research.apigatewaysimplecomplexity.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@Data
@RequiredArgsConstructor
public class AccountLastTransactionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userAccountId", nullable = false)
    private Long userAccountId;

    private Long accountNumber;
    private Long userBalance;
    private Long lastTransaction;

    public AccountLastTransactionEntity(Long userAccountId, Long accountNumber, Long userBalance, Long lastTransaction) {
        this.userAccountId = userAccountId;
        this.accountNumber = accountNumber;
        this.userBalance = userBalance;
        this.lastTransaction = lastTransaction;
    }
}
