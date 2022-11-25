package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String password;
    private final Role role;
}
