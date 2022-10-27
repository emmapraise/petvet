package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Pet_Category;

import java.util.List;

public interface PetCategoryService {


    Pet_Category addPetCategory(Pet_Category pet_category);

    List<Pet_Category> getPetCategories();
}
