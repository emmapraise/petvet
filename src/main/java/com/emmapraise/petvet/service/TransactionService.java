package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.TransactionDto;

public interface TransactionService {
    TransactionDto acceptPayment(String appointmentUuid, TransactionDto transactionDto);
}
