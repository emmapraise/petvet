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
    @Column(name = "logo_path")
    private String logo;
    @Column(name = "cover_image_path")
    private String coverImage;
    @Column(name = "address")
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "email", unique = true)
    private String email;
    private Double price;

    @Column(name = "is_available")
    private Boolean isAvailable = false;

    @Column(name = "document_path")
    private String document;
    
    private Boolean isApproved = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties;
}
