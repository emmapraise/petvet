package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Diagonises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @OneToOne(fetch = FetchType.EAGER)
    private Appointment appointment = new Appointment();
    @OneToOne(fetch = FetchType.EAGER)
    private Pets pets = new Pets();
}
