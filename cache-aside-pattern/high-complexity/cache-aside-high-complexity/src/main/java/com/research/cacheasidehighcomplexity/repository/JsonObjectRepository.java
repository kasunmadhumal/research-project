package com.research.cacheasidehighcomplexity.repository;

import com.research.cacheasidehighcomplexity.entity.JsonObjectTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JsonObjectRepository extends JpaRepository<JsonObjectTransactionEntity, Long> {

    Optional<JsonObjectTransactionEntity> findById(Long id);

    void deleteById(Long id);

}
