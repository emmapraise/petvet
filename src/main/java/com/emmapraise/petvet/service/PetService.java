package com.emmapraise.petvet.service;

import com.emmapraise.petvet.Domain.Pets;

import java.util.List;

public interface PetService {
    Pets addPet(long userId, String categoryName, Pets pets);

    String deletePet(long petId);

    List<Pets> getPets();
}
