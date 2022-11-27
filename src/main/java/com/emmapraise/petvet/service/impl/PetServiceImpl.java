package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.PetOwner;
import com.emmapraise.petvet.entity.PetType;
import com.emmapraise.petvet.entity.Pet;
import com.emmapraise.petvet.payload.PetDto;
import com.emmapraise.petvet.repo.OwnerRepo;
import com.emmapraise.petvet.repo.PetTypeRepo;
import com.emmapraise.petvet.repo.PetRepo;
import com.emmapraise.petvet.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final OwnerRepo ownerRepo;

    private final PetTypeRepo petTypeRepo;
    private final PetRepo petRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<PetDto> getPets() {
        log.info("Getting all pets");
        return petRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public PetDto addPet(long ownerId, String categoryName, PetDto petDto) {
        log.info("Saving pets");
        Pet pet = mapToEntity(petDto);
        PetOwner petOwner = ownerRepo.findById(ownerId).orElseThrow(() -> new IllegalStateException("Owner not found "));
        PetType pet_type = petTypeRepo.findByName(categoryName);
        pet.setPetOwner(petOwner);
        pet.setType(pet_type);
        return mapToDto(petRepo.save(pet));
    }

    @Override
    public PetDto getPet(long petId) {
        Pet pet = petRepo.findById(petId).orElseThrow(() -> new IllegalStateException("There is no pet with the id " + petId));
        return mapToDto(pet);
    }

    @Override
    public String deletePet(long petId) {
        log.info("Deleting the pet with id {}", petId);
        boolean exists = petRepo.existsById(petId);
        log.info("Ok do the pet exists at all {}", exists);
        if (!exists) {
            throw new IllegalStateException("There is no pet with the id " + petId);
        }
        petRepo.deleteById(petId);
        return "Pet has been deleted";
    }

    @Override
    @Transactional
    public PetDto updatePet(long petId, PetDto petDto) {
        Pet pet = petRepo.findById(petId).orElseThrow(() -> new IllegalStateException("There is no pet with the id " + petId));
        pet.setName(petDto.getName());
        pet.setBirthdate(petDto.getBirthdate());
        return mapToDto(pet);
    }

    private PetDto mapToDto(Pet pet) {
        return mapper.map(pet, PetDto.class);
    }

    private Pet mapToEntity(PetDto petDto) {
        return mapper.map(petDto, Pet.class);
    }
}
