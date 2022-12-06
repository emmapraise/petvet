package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Role roles;
}
