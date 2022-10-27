package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Pets;
import com.emmapraise.petvet.payload.AppointmentDto;
import com.emmapraise.petvet.payload.PetDto;
import com.emmapraise.petvet.repo.AppUserRepo;
import com.emmapraise.petvet.repo.AppointmentRepo;
import com.emmapraise.petvet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Slf4j @Transactional @RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;

    private final AppUserRepo appUserRepo;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public AppointmentDto createAppointment(long clinicId, long clientId, AppointmentDto appointmentDto) {
        log.info("Saving appointment into the Database");
        Appointment appointment = mapToEntity(appointmentDto);
        AppUser clinic = appUserRepo.findById(clinicId).orElseThrow(()-> new IllegalStateException("No clinic found"));
        AppUser client = appUserRepo.findById(clientId).orElseThrow(()-> new IllegalStateException("No client found"));
        appointment.setClient(client);
        appointment.setClinic(clinic);
        log.info("Appointment Saved Successfully");
        return mapToDto(appointmentRepo.save(appointment));
    }
    private AppointmentDto mapToDto(Appointment appointment){
        return  mapper.map(appointment, AppointmentDto.class);
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto){
        return mapper.map(appointmentDto, Appointment.class);
    }
}
