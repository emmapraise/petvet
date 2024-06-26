package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    List<AppUser> getUsers();

//    AppUser saveUser(AppUser appUser);

    AppUser signUpUser(AppUser appUser);

    AppUser getUser(long userId);

    String deleteUser(String email);

    int enableAppUser(String email);
}
