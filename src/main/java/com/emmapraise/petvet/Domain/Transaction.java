package com.emmapraise.petvet.Domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TransactionStatus status = TransactionStatus.PENDING;
    @Column(unique = true)
    private String ref;
}
