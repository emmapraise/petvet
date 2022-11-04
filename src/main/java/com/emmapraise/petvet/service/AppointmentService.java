package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.AppointmentDto;

public interface AppointmentService {
    AppointmentDto createAppointment(long petId, long vetId, AppointmentDto appointmentDto);
}
