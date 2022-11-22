package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Attach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachRepo extends JpaRepository<Attach, Long> {
    Attach findByName(String name);
}
