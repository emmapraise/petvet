package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Pets;
import com.emmapraise.petvet.payload.PetDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {
    PetDto addPet(long userId, String categoryName, PetDto petDto);

    String deletePet(long petId);

    Pets updatePet(long petId, Pets pets);

    List<Pets> getPets();
}
