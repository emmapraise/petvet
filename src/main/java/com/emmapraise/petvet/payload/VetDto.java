package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.Role;
import com.emmapraise.petvet.entity.Specialty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VetDto {
    private long id;
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String firstName;
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String lastName;
    @NotEmpty
    @Email
    @Column(unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String phone;
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Role role = Role.VET;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    private AttachDto logo;

    private AttachDto coverImage;

    @NotEmpty
    private String address;

//    @NotEmpty
//    @Column(unique = true)
//    private String phone;

//    @NotEmpty
//    @Column(unique = true)
//    @Email
//    private String email;

    @NotEmpty
    @Digits(fraction = 2, integer = 10)
    private Double price;

    private AttachDto document;

    private Boolean isAvailable = true;

    private Boolean isApproved = false;
    private Set<Specialty> specialties;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private RegistrationRequest user;
}
