package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.AppUser;

import java.util.List;

public interface AppUserSerivce {
    List<AppUser> getUsers();

    AppUser saveUser(AppUser appUser);

    AppUser getUser(String email);
}
