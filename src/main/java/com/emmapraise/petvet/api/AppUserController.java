package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.payload.RegistrationRequest;
import com.emmapraise.petvet.service.AppUserService;
import com.emmapraise.petvet.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AppUserController {
    private final AppUserService appUserService;
    private final RegistrationService registrationService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

//    @PostMapping("/user/save")
//    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
//        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
//    }

    @PostMapping("/user/register")
    public AppUser register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping("/user/register/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping("/user")
    public ResponseEntity<AppUser> getUser(@AuthenticationPrincipal AppUser currentUser) {
        return ResponseEntity.ok().body(appUserService.getUser(currentUser));
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(appUserService.deleteUser(email));
    }

}
