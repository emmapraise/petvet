package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.ConfirmationToken;
import com.emmapraise.petvet.payload.RegistrationRequest;

public interface RegistrationService {
    AppUser register(RegistrationRequest request);

    String confirmToken(String token);
}
