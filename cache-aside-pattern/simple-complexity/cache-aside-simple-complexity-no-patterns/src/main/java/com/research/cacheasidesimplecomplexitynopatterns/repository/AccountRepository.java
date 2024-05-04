package com.research.cacheasidesimplecomplexitynopatterns.repository;

import com.research.cacheasidesimplecomplexitynopatterns.entity.AccountLastTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountLastTransactionEntity, Long> {

    AccountLastTransactionEntity findByAccountNumber(Long accountNumber);
}
