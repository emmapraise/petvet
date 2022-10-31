package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.PetType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
public class PetDto {
    private long id;

    @NotEmpty(message = "The pet name is required")
    private String name;
    @NotEmpty(message = "The Pet Eye colour is needed")
    private String eyeColor;

    private AppUser appUser;
    private PetType petCategory;

}
