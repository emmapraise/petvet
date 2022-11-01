package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepo extends JpaRepository<Vet, Long> {
    Vet findByEmail(String email);
    Boolean existsByEmail(String email);

    void deleteByEmail(String email);
}
