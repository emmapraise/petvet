package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TransactionDto {
    private long id;

    @NotEmpty
    @Digits(fraction = 2, integer = 10)
    private Double price;

    @NotEmpty
    @Column(unique = true)
    private String ref;

    private Status status = Status.PENDING;

    private Appointment appointment;
}
