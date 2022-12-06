package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.Pet;
import com.emmapraise.petvet.payload.JWTAuthResponse;
import com.emmapraise.petvet.payload.LoginDto;
import com.emmapraise.petvet.payload.PetDto;
import com.emmapraise.petvet.payload.RegistrationRequest;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.security.config.JwtTokenProvider;
import com.emmapraise.petvet.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {
    private AuthenticationManager authenticationManager;
    private AppUserRepo appUserRepo;
    private JwtTokenProvider tokenProvider;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public JWTAuthResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = appUserRepo.findByEmail(currentUsername).orElseThrow(() -> new IllegalStateException("No user found"));
        String token = tokenProvider.generateToken(authentication);
        return new JWTAuthResponse(token, mapToDto(appUser));
    }

    private RegistrationRequest mapToDto(AppUser appUser) {
        return mapper.map(appUser, RegistrationRequest.class);
    }
}
