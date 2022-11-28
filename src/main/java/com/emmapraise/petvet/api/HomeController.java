package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<AppUser> getUser(long userId) {
        return ResponseEntity.ok().body(appUserService.getUser(userId));
    }
}
