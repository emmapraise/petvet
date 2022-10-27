package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.AppUser;
import com.emmapraise.petvet.Domain.Pet_Category;
import com.emmapraise.petvet.Domain.Pets;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.repo.PetCategoryRepo;
import com.emmapraise.petvet.repo.PetRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service @Slf4j @Transactional @RequiredArgsConstructor
public class PetServiceImpl implements PetService{

    private final AppUserRepo appUserRepo;

    private final PetCategoryRepo petCategoryRepo;
    private final PetRepo petRepo;

    @Override
    public List<Pets> getPets() {
        log.info("Getting all pets");
        return petRepo.findAll();
    }

    @Override
    public Pets addPet(long userId, String categoryName, Pets pets) {
        log.info("Saving pets");
        AppUser appUser = appUserRepo.findById(userId).orElseThrow(() -> new IllegalStateException("User not Found"));
        Pet_Category pet_category = petCategoryRepo.findByName(categoryName);
        pets.setAppUser(appUser);
        pets.setPet_category(pet_category);
        return petRepo.save(pets);
    }

    @Override
    public String deletePet(long petId) {
        boolean exists = petRepo.existsById(petId);
        if (!exists){
            throw new IllegalStateException("There is no pet with the id "+ petId);
        }
        petRepo.deleteById(petId);
        return "Pet has been deleted";
    }
}
