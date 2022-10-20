package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getUsers();

    AppUser saveUser(AppUser appUser);

    AppUser getUser(String email);

//    AppUser deleteUser(String email);
}
