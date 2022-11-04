package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
}
