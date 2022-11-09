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
    public List<AppointmentDto> getAppointments() {
        log.info("Get all appointment");
        return appointmentRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override @Transactional
    public AppointmentDto changeAppointmentStatus(long appointmentId, Status status) {
        log.info("Update Appointment Status to {}", status);
        if (appointmentRepo.existsById(appointmentId)){
            Appointment appointment = appointmentRepo.findById(appointmentId);
            appointment.setStatus(status);
            return mapToDto(appointment);
        }
        throw new IllegalStateException("No Appointment Found");

    }

    @Override
    public List<AppointmentDto> getAppointmentByStatus(Status status) {
        return appointmentRepo.findAllByStatus(status).stream().map(this::mapToDto).toList();
    }

    private AppointmentDto mapToDto(Appointment appointment) {
        return mapper.map(appointment, AppointmentDto.class);
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        return mapper.map(appointmentDto, Appointment.class);
    }
}
