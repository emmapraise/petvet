package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.Domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
