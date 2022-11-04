package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepo extends JpaRepository<PetType, Long> {
    PetType findByName(String name);
}
