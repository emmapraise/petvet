package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepo extends JpaRepository<Specialty, Long> {
}
