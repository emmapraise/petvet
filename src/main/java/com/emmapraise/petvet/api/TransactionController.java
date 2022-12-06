package com.emmapraise.petvet.api;

import com.emmapraise.petvet.Payment.PaymentResponse;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.payload.TransactionDto;
import com.emmapraise.petvet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/payment/appointment/{uuid}")
    public ResponseEntity<TransactionDto> acceptPayment(@PathVariable(value = "uuid") String appointmentUuid,
                                                        @RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok().body(transactionService.acceptPayment(appointmentUuid, transactionDto));
    }

    @PatchMapping("/payment/ref/{ref}/status/{status}")
    public ResponseEntity<TransactionDto> updateTransactionStatus(@PathVariable(value = "ref") String ref,
                                                                  @PathVariable(value = "status") Status status) {
        return ResponseEntity.ok().body(transactionService.updateTransactionStatus(ref, status));
    }

    @GetMapping("/payment/verify/ref/{ref}")
    public ResponseEntity<PaymentResponse> verifyPayment(@PathVariable(value = "ref") String ref) {
        return ResponseEntity.ok().body(transactionService.verifyPayment(ref));
    }

    @GetMapping("/payment/all")
    public ResponseEntity<List<TransactionDto>> getTransactions() {
        return ResponseEntity.ok().body(transactionService.getTransactions());
    }

    @GetMapping("/payment/status/{status}")
    public ResponseEntity<List<TransactionDto>> getTransactionByDto(@PathVariable(value = "status") Status status) {
        return ResponseEntity.ok().body(transactionService.getTransactionsByStatus(status));
    }
}
