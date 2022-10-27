package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.AppointmentDto;

public interface AppointmentService {
    AppointmentDto createAppointment(long clinicId, long clientId, AppointmentDto appointmentDto);
}
