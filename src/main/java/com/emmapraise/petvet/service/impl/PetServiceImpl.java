package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.Pet_Category;
import com.emmapraise.petvet.entity.Pets;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.repo.PetCategoryRepo;
import com.emmapraise.petvet.repo.PetRepo;
import com.emmapraise.petvet.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service @Slf4j @Transactional @RequiredArgsConstructor
public class PetServiceImpl implements PetService {

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

    //FIXME fix issues with pet deleting now working
    @Override
    public String deletePet(long petId) {
        log.info("Deleting the pet with id {}", petId);
        boolean exists = petRepo.existsById(petId);
        log.info("Ok do the pet exists at all {}", exists);
        if (!exists){
            throw new IllegalStateException("There is no pet with the id "+ petId);
        }
        petRepo.deleteById(petId);
        return "Pet has been deleted";
    }

    //TODO Make sure the Update Pet is working
    @Override
    @Transactional
    public Pets updatePet(long petId, Pets pets) {
        petRepo.findById(petId).orElseThrow(()-> new IllegalStateException("There is no pet with the id"+ petId));
        return null;
    }
}
