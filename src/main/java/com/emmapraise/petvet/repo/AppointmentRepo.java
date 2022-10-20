package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.Domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByUuid(String uuid);
}
