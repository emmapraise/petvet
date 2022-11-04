package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Pet;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.entity.Vet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class AppointmentDto {
    private long id;

    @NotNull(message = "Date filed is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date;

    private Pet pet;
    private Vet vet;
    private Double price;
    private Status status;
}
