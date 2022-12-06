package com.emmapraise.petvet.repo;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.PetOwner;
import com.emmapraise.petvet.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByUuid(String uuid);

    List<Appointment> findAppointmentsByPet_PetOwnerOrderByCreatedAtDesc(PetOwner pet_petOwner);

    List<Appointment> findAppointmentsByVet_User_Id(long vet_user_id);

    Appointment findById(long id);

    List<Appointment> findAllByStatus(Status status);

}
