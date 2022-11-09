package com.emmapraise.petvet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "reviews")
public class Review extends BaseEntity{
    private String review;
    private int rating;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Appointment appointment;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Owner owner;
}
