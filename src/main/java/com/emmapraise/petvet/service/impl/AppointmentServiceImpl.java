package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Pet;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.AppointmentDto;
import com.emmapraise.petvet.repo.*;
import com.emmapraise.petvet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;

    private final PetRepo petRepo;
    private final VetRepo vetRepo;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public AppointmentDto createAppointment(long petId, long vetId, AppointmentDto appointmentDto) {
        log.info("Saving appointment into the Database");
        Appointment appointment = mapToEntity(appointmentDto);
        Pet pet = petRepo.findById(petId).orElseThrow(() -> new IllegalStateException("Pet with the id " + petId + " not found"));
        Vet vet = vetRepo.findById(vetId).orElseThrow(() -> new IllegalStateException("No vet found"));
        appointment.setPet(pet);
        appointment.setVet(vet);
        log.info("Appointment Saved Successfully");
        return mapToDto(appointmentRepo.save(appointment));
    }

    @Override
    public List<Appointment> getAppointments() {
        log.info("Get all appointment");
        return appointmentRepo.findAll();
    }

    @Override @Transactional
    public AppointmentDto changeAppointmentStatus(long appointmentId, Status status) {
        log.info("Update Appointment Status to {}", status);
        Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow(()-> new IllegalStateException("Appointment not found"));
        appointment.setStatus(status);
        return mapToDto(appointment);
    }

    @Override
    public List<Appointment> getAppointmentByStatus(Status status) {
        return appointmentRepo.findAllByStatus(status);
    }

    private AppointmentDto mapToDto(Appointment appointment) {
        return mapper.map(appointment, AppointmentDto.class);
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        return mapper.map(appointmentDto, Appointment.class);
    }
}
