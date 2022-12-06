package com.emmapraise.petvet.payload;

import com.emmapraise.petvet.entity.AppUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class JWTAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private RegistrationRequest user;

    public JWTAuthResponse(String accessToken, RegistrationRequest user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
