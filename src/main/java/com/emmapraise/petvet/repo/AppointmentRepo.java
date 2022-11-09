package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByUuid(String uuid);

    List<Appointment> findAllByStatus(Status status);

}
