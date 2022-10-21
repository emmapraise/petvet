package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.Pet_Category;
import com.emmapraise.petvet.repo.PetCategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PetCategoryServiceImpl implements PetCategoryService{
    private final PetCategoryRepo petCategoryRepo;

    @Override
    public Pet_Category addPetCategory(Pet_Category pet_category) {
        log.info("Saving pet with the details {} ", pet_category.getName());
        return petCategoryRepo.save(pet_category);
    }

    @Override
    public List<Pet_Category> getPetCategories() {
        return null;
    }
}
