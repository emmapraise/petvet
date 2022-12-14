package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Transaction findByRef(String ref);
}
