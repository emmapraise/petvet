package com.emmapraise.petvet.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TransactionServiceImpl implements TransactionService {
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
    public TransactionDto acceptPayment(String appointmentUuid, TransactionDto transactionDto) {
        log.info("Transaction saved into the database");
        if (transactionRepo.existsByRef(transactionDto.getRef())){
            throw new IllegalStateException("Reference code already exists");
        }
        Transaction transaction = mapToEntity(transactionDto);
        Appointment appointment = appointmentRepo.findByUuid(appointmentUuid);
        transaction.setAppointment(appointment);
        return mapToDto(transactionRepo.save(transaction));
    }

    private TransactionDto mapToDto(Transaction transaction) {
        return mapper.map(transaction, TransactionDto.class);
    }

    private Transaction mapToEntity(TransactionDto transactionDto) {
        return mapper.map(transactionDto, Transaction.class);
    }
}
