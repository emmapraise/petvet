package com.emmapraise.petvet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owners")
public class PetOwner extends BaseEntity {
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;

//    @Column(name = "email", unique = true)
//    private String email;
//    @Column(name = "telephone", unique = true)
//    private String phone;
    @OneToOne
    private AppUser user;

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL)
    private Set<Pet> pets;

}
