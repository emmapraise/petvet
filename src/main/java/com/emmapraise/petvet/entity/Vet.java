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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vets")
public class Vet extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private Attach logo;

    @OneToOne
    private Attach coverImage;

    @Column(name = "address")
    private String address;

//    @Column(name = "phone", nullable = false)
//    private String phone;
//    @Column(name = "email", unique = true)
//    private String email;

    @OneToOne
    private AppUser user;

    private Double price;

    @Column(name = "is_available")
    private Boolean isAvailable = false;

    @OneToOne
    private Attach document;

    private Boolean isApproved = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties;
}
