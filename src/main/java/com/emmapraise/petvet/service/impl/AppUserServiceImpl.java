package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;

import com.emmapraise.petvet.entity.ConfirmationToken;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    private final static String USER_NOT_FOUND_MSG = "User with the email %s not found";

    @Override
    public List<AppUser> getUsers() {
        log.info("Retrieving all users");
        return appUserRepo.findAll();
    }

//    @Override
//    public AppUser saveUser(AppUser appUser) {
//        log.info("Saving new user {} {} into the database", appUser.getFirst_name(), appUser.getLast_name());
//        Optional<AppUser> appUserOptional = appUserRepo.findByEmail(appUser.getEmail());
//        if (appUserOptional.isPresent()) {
//            throw new IllegalStateException("Email taken");
//        }
//        return appUserRepo.save(appUser);
//    }

    @Override
    public AppUser getUser(long userId) {
        log.info("Retrieving user {} from the database", userId);
        return appUserRepo.findById(userId).orElseThrow(() ->
                new IllegalStateException("No user present"));
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

    @Override
    public int enableAppUser(String email) {
        return appUserRepo.enableAppUser(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//        return appUserRepo.findByEmail(email)
//                .orElseThrow(()-> new UsernameNotFoundException(
//                        String.format(USER_NOT_FOUND_MSG, email)));
//    }

    @Override
    public AppUser signUpUser(AppUser appUser) {
        boolean userExist = appUserRepo.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = passwordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        return appUserRepo.save(appUser);
    }
}
