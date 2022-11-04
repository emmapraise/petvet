package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    void deleteByEmail(String email);
}
