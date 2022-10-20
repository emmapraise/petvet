package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.AppUser;

import com.emmapraise.petvet.repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepo appUserRepo;

    @Override
    public List<AppUser> getUsers(){
        log.info("Retrieving all users");
        return appUserRepo.findAll();
    }

    @Override
    public AppUser saveUser(AppUser appUser){
        log.info("Saving new user {} {} into the database", appUser.getFirst_name(), appUser.getLast_name());
        return appUserRepo.save(appUser);
    }
    @Override
    public AppUser getUser(String email){
        log.info("Retrieving user {} from the database", email);
        return appUserRepo.findByEmail(email);
    }
}
