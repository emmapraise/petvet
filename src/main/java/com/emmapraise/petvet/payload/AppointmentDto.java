package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class AppointmentDto {
    private long id;
//    @NotNull(message = "Date filed is required")
    private Date date;

    private AppUser client;
    private AppUser clinic;
    private Double price;
}
