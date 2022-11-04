package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
    Owner findByFirstName(String firstName);

    Owner findByLastName(String lastName);

    Owner findByEmail(String email);

    void deleteByEmail(String email);

    Boolean existsByEmail(String email);
}
