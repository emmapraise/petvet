package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Pets;
import com.emmapraise.petvet.payload.PetDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {
    PetDto addPet(long userId, String categoryName, PetDto petDto);

    PetDto getPet(long petId);

    String deletePet(long petId);

    PetDto updatePet(long petId, PetDto petDto);

    List<Pets> getPets();
}
