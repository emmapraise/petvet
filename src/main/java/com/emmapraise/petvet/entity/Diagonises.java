package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Diagonises extends BaseEntity{
    private String title;
    private String description;
    @OneToOne(fetch = FetchType.EAGER)
    private Appointment appointment = new Appointment();
    @OneToOne(fetch = FetchType.EAGER)
    private Pet pet = new Pet();
}
