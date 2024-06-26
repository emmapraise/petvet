package com.emmapraise.petvet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "owner_id")
    private PetOwner petOwner;

    private Boolean isActive = true;
}
