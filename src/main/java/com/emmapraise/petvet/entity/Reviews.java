package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String review;
    private Integer rating;
    @ManyToOne(fetch = FetchType.EAGER)
    private Appointment appointment = new Appointment();
}
