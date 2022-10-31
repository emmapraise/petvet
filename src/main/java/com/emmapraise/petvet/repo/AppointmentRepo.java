package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByUuid(String uuid);
}
