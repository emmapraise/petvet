package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String uuid = UUID.randomUUID().toString();

    @ManyToOne()
    private AppUser client;

    @ManyToOne()
    private AppUser clinic;
    private Date date;
    private Double price;
}
