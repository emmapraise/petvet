package com.emmapraise.petvet.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialityToVetForm {
    private long vetId;
    private long specialtyId;
}
