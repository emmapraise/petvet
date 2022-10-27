package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Pets;

import java.util.List;

public interface PetService {
    Pets addPet(long userId, String categoryName, Pets pets);

    String deletePet(long petId);

    Pets updatePet(long petId, Pets pets);

    List<Pets> getPets();
}
