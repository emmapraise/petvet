package com.emmapraise.petvet.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class OwnerDto {
    private long id;

    @NotEmpty(message = "This is field is required")
    private String first_name;

    @NotEmpty
    private String last_name;
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String phone;

    private String address;

    private String city;
}
