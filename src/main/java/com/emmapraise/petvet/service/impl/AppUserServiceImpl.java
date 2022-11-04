package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;

import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.service.AppUserService;
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
    public List<AppUser> getUsers() {
        log.info("Retrieving all users");
        return appUserRepo.findAll();
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} {} into the database", appUser.getFirst_name(), appUser.getLast_name());
        Optional<AppUser> appUserOptional = appUserRepo.findByEmail(appUser.getEmail());
        if (appUserOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        return appUserRepo.save(appUser);
    }

    @Override
    public Optional<AppUser> getUser(String email) {
        log.info("Retrieving user {} from the database", email);
//        boolean exists = appUserRepo.existsByEmail(email);
        Optional<AppUser> appUserOptional = appUserRepo.findByEmail(email);

        if (appUserOptional.isPresent()) {
            return appUserOptional;
        }
        throw new IllegalStateException("User is not present");
    }

    public String deleteUser(String email) {
        log.info("Deleting User with email " + email);
        Optional<AppUser> appUserOptional = appUserRepo.findByEmail(email);
        if (appUserOptional.isPresent()) {
            appUserRepo.deleteByEmail(email);
            return "User deleted";
        }
        throw new IllegalStateException("User is not present");
    }
}
