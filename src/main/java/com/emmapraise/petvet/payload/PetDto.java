package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.Owner;
import com.emmapraise.petvet.entity.PetType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class PetDto {
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotEmpty(message = "The pet name is required")
    private String name;

    private OwnerDto owner;
    private PetType petType;

}
