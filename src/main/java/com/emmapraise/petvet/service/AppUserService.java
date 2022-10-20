package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUser> getUsers();

    AppUser saveUser(AppUser appUser);

    Optional<AppUser> getUser(String email);

    String deleteUser(String email);
}
