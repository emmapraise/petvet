package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Boolean existsByRef(String ref);
}
