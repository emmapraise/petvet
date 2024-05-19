package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.PetType;
import com.emmapraise.petvet.repo.PetTypeRepo;
import com.emmapraise.petvet.service.PetCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PetCategoryServiceImpl implements PetCategoryService {
    private final PetTypeRepo petTypeRepo;

    @Override
    public PetType addPetCategory(PetType pet_type) {
        log.info("Saving pet with the details {} ", pet_type.getName());
        return petTypeRepo.save(pet_type);
    }

    @Override
    public List<PetType> getPetCategories() {
        return petTypeRepo.findAll();
    }
}
