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
    private AppUser appUser;

    public JWTAuthResponse(String accessToken, AppUser appUser) {
        this.accessToken = accessToken;
        this.appUser = appUser;
    }
}
