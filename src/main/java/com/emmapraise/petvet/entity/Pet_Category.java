package com.emmapraise.petvet.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "pet_categories")
public class Pet_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "pet_category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pets> pets = new HashSet<>();
}
