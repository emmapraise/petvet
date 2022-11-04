package com.emmapraise.petvet.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * These are the Types of Pets available
 * this can be Cat, Dog, Horse etc
 *
 * @author Emmanuel.Oludare
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "types")
public class PetType extends BaseEntity {
    @Column(unique = true, nullable = false, name = "name")
    private String name;
//    @OneToMany(mappedBy = "pet_type", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Pets> pets = new HashSet<>();
}
