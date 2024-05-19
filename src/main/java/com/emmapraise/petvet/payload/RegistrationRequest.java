package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private  String firstName;
    private  String lastName;
    private String email;
    private String phone;
    private String password;
    private Role role;
}
