package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "transactions")
public class Transaction extends BaseEntity {
    private Double price;

    @Column(unique = true)
    private String ref;

    @OneToOne
    private Appointment appointment;

    private Status status = Status.PENDING;
}
