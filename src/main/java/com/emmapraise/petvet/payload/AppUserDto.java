package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role roles;
}
