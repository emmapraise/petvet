package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.PetType;

import java.util.List;

public interface PetCategoryService {


    PetType addPetCategory(PetType pet_type);

    List<PetType> getPetCategories();
}
