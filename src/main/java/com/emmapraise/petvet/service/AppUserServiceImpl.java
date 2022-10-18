package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.AppUser;
import com.emmapraise.petvet.repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserServiceImpl implements AppUserSerivce{
    private final AppUserRepo appUserRepo;

    @Override
    public List<AppUser> getUsers(){
        return appUserRepo.findAll();
    }
}
