package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.payload.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(long petId, long vetId, AppointmentDto appointmentDto);

    List<Appointment> getAppointments();

    List<Appointment> getAppointmentByStatus(Status status);

    AppointmentDto changeAppointmentStatus(long appointmentId, Status status);
}
