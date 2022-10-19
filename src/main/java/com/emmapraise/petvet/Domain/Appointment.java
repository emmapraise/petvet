package com.emmapraise.petvet.Domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private AppUser client = new AppUser();
    @OneToOne(fetch = FetchType.EAGER)
    private AppUser clinic = new AppUser();
    private Date date;
    private Double price;
}
