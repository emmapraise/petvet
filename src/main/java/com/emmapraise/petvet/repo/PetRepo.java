package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pets, Long> {
    Pets findByName(String name);
}
