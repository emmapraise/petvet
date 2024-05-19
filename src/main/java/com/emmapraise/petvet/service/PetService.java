package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.PetDto;

import java.util.List;

public interface PetService {
    PetDto addPet(long ownerId, String categoryName, PetDto petDto);

    PetDto getPet(long petId);

    List<PetDto> getPetsByOwner(long ownerId);

    String deletePet(long petId);

    PetDto updatePet(long petId, PetDto petDto);

    List<PetDto> getPets();
}
