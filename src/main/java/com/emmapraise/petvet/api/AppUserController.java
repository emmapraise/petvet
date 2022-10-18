package com.emmapraise.petvet.api;

import com.emmapraise.petvet.Domain.AppUser;
import com.emmapraise.petvet.service.AppUserSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserSerivce appUserSerivce;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(appUserSerivce.getUsers());
    }
}
