package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Boolean existsByRef(String ref);

    List<Transaction> findAllByStatus(Status status);
}
