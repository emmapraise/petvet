package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.Pets;
import com.emmapraise.petvet.repo.PetRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Slf4j @Transactional @RequiredArgsConstructor
public class PetServiceImpl implements PetService{

    private final PetRepo petRepo;

    @Override
    public List<Pets> getPets() {
        log.info("Getting all pets");
        return petRepo.findAll();
    }
}
