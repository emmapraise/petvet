package com.emmapraise.petvet.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String eyeColor;
    @OneToOne()
    private Pet_Category pet_category = new Pet_Category();
    private Boolean isActive = true;
}
