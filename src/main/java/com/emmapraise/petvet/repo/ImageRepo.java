package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {
    Image findByName(String name);
}
