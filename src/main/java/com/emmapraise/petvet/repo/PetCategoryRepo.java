package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Pet_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetCategoryRepo extends JpaRepository<Pet_Category, Long> {
    Pet_Category findByName(String name);
}
