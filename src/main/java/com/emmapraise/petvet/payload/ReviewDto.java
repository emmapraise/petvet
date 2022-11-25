package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.PetOwner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReviewDto {
    private long id;

    @NotEmpty
    private String review;

    @NotEmpty
    @Max(value = 5)
    @Min(value = 1)
    private int rating;

    @JsonIgnore
    private Appointment appointment;

    @JsonIgnore
    private PetOwner petOwner;
}
