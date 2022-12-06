package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.JWTAuthResponse;
import com.emmapraise.petvet.payload.LoginDto;

public interface AuthService {

    JWTAuthResponse login(LoginDto loginDto);
}
