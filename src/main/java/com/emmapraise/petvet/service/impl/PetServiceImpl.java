package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.PetType;
import com.emmapraise.petvet.entity.Pets;
import com.emmapraise.petvet.payload.PetDto;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.repo.PetCategoryRepo;
import com.emmapraise.petvet.repo.PetRepo;
import com.emmapraise.petvet.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service @Slf4j @Transactional @RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final AppUserRepo appUserRepo;

    private final PetCategoryRepo petCategoryRepo;
    private final PetRepo petRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<Pets> getPets() {
        log.info("Getting all pets");
        return petRepo.findAll();
    }

    @Override
    public PetDto addPet(long userId, String categoryName, PetDto petDto) {
        log.info("Saving pets");
        Pets pets = mapToEntity(petDto);
        AppUser appUser = appUserRepo.findById(userId).orElseThrow(() -> new IllegalStateException("User not Found"));
        PetType pet_type = petCategoryRepo.findByName(categoryName);
        pets.setAppUser(appUser);
        pets.setType(pet_type);
        return  mapToDto(petRepo.save(pets));
    }

    @Override
    public PetDto getPet(long petId) {
        Pets pets = petRepo.findById(petId).orElseThrow(()-> new IllegalStateException("There is no pet with the id " + petId));
        return mapToDto(pets);
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
    public PetDto updatePet(long petId, PetDto petDto) {
        Pets pet = petRepo.findById(petId).orElseThrow(()-> new IllegalStateException("There is no pet with the id "+ petId));
        pet.setName(petDto.getName());
        pet.setBirthdate(petDto.getBirthdate());
        return mapToDto(pet);
    }

    private PetDto mapToDto(Pets pets){
        return  mapper.map(pets, PetDto.class);
    }
    private Pets mapToEntity(PetDto petDto){
        return mapper.map(petDto, Pets.class);
    }
}
