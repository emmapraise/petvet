package com.emmapraise.petvet.api;

import com.emmapraise.petvet.Domain.AppUser;
import com.emmapraise.petvet.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<Optional<AppUser>> getUser(@PathVariable("email") String email){
        return ResponseEntity.ok().body(appUserService.getUser(email));
    }
    @DeleteMapping("/user/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email){
        return ResponseEntity.ok().body(appUserService.deleteUser(email));
    }

}
