package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUser> getUsers();

//    AppUser saveUser(AppUser appUser);

    String signUpUser(AppUser appUser);

    Optional<AppUser> getUser(String email);

    String deleteUser(String email);

    int enableAppUser(String email);
}
