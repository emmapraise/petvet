package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.Payment.PaymentResponse;
import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.entity.Transaction;
import com.emmapraise.petvet.payload.TransactionDto;
import com.emmapraise.petvet.repo.AppointmentRepo;
import com.emmapraise.petvet.repo.TransactionRepo;
import com.emmapraise.petvet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Value("${app.merchant_code}")
    private String merchant_code;
    private final TransactionRepo transactionRepo;
    private final AppointmentRepo appointmentRepo;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<TransactionDto> getTransactions() {
        return transactionRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public List<TransactionDto> getTransactionsByStatus(Status status) {
        return transactionRepo.findAllByStatus(status).stream().map(transaction -> mapToDto(transaction)).toList();
    }

    @Override
    public TransactionDto updateTransactionStatus(String ref, Status status) {
        if (transactionRepo.existsByRef(ref)) {
            Transaction transaction = transactionRepo.findByRef(ref);
            transaction.setStatus(status);
            return mapToDto(transactionRepo.save(transaction));
        }
        throw new IllegalStateException("No Transaction with the ref code " + ref);
    }

    @Override
    public TransactionDto acceptPayment(String appointmentUuid, TransactionDto transactionDto) {
        log.info("Transaction saved into the database");
        if (transactionRepo.existsByRef(transactionDto.getRef())) {
            throw new IllegalStateException("Reference code already exists");
        }
        Transaction transaction = mapToEntity(transactionDto);
        Appointment appointment = appointmentRepo.findByUuid(appointmentUuid);
        transaction.setAppointment(appointment);
        return mapToDto(transactionRepo.save(transaction));
    }

    @Override
    public PaymentResponse verifyPayment(String ref) {
        //Check if transaction of that ref exist in the database
        if (transactionRepo.existsByRef(ref)) {
            Transaction transaction = transactionRepo.findByRef(ref);
            try {
                String uri = "https://qa.interswitchng.com/collections/api/v1/gettransaction.json?merchantcode="
                        + merchant_code + "&transactionreference=" + ref + "&amount=" + transaction.getPrice();
                log.info("The ref code is {} while the price is {}", ref, transaction.getPrice());
                RestTemplate restTemplate = new RestTemplate();
                PaymentResponse response = restTemplate.getForObject(uri, PaymentResponse.class);
                log.info("The response is {}", response);
                log.info("{}", restTemplate.getForObject(uri, PaymentResponse.class));
                return response;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalStateException("Just an error i dont know why");
    }

    private TransactionDto mapToDto(Transaction transaction) {
        return mapper.map(transaction, TransactionDto.class);
    }

    private Transaction mapToEntity(TransactionDto transactionDto) {
        return mapper.map(transactionDto, Transaction.class);
    }
}
