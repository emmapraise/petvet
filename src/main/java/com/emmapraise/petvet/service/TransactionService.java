package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Payment.PaymentResponse;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto acceptPayment(String appointmentUuid, TransactionDto transactionDto);
    List<TransactionDto> getTransactions();

    List<TransactionDto> getTransactionsByStatus(Status status);

    TransactionDto updateTransactionStatus(String ref, Status status);

    PaymentResponse verifyPayment(String ref);
}
