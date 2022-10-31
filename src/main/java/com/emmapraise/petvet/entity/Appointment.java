package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment extends BaseEntity{
    @Column(unique = true)
    private String uuid = UUID.randomUUID().toString();

    @ManyToOne()
    private AppUser client;

    @ManyToOne()
    private AppUser clinic;
    private Date date;
}
