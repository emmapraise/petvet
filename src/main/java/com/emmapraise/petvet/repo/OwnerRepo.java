package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepo extends JpaRepository<PetOwner, Long> {
//    PetOwner findByFirstName(String firstName);

    Optional<PetOwner> findByUserId(long userId);

//
//    PetOwner findByLastName(String lastName);
//
//    PetOwner findByEmail(String email);

//    void deleteByEmail(String email);

//    Boolean existsByEmail(String email);
}
