package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Specialty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
public class VetDto {
    private long id;
    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    @Column(unique = true)
    private String phone;

    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Digits(fraction = 2, integer = 10)
    private Double price;

    private Boolean isAvailable;
    private Set<Specialty> specialties;
}
