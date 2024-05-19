package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.payload.JWTAuthResponse;
import com.emmapraise.petvet.payload.LoginDto;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.security.config.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private AuthenticationManager authenticationManager;

    private AppUserRepo appUserRepo;


    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String currentUsername =  SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = appUserRepo.findByEmail(currentUsername).orElseThrow(()-> new IllegalStateException("No user found"));
        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTAuthResponse(token, appUser));
    }
}
