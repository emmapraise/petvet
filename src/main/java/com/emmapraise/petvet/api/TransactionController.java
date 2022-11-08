package com.emmapraise.petvet.api;

import com.emmapraise.petvet.payload.TransactionDto;
import com.emmapraise.petvet.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService paymentService;

    @PostMapping("/appointment/{uuid}/pay")
    public ResponseEntity<TransactionDto> acceptPayment(@PathVariable(value = "uuid") String appointmentUuid,
                                                        @RequestBody TransactionDto transactionDto){
        return ResponseEntity.ok().body(paymentService.acceptPayment(appointmentUuid, transactionDto));
    }
}
