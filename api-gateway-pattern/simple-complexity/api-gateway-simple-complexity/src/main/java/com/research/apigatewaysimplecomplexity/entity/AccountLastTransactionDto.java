package com.research.apigatewaysimplecomplexity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AccountLastTransactionDto {

    private Long accountNumber;
    private Long userBalance;
    private Long lastTransaction;
}
