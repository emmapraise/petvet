package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Appointment;
import com.emmapraise.petvet.entity.Status;
import com.emmapraise.petvet.payload.AppointmentDto;
import com.emmapraise.petvet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/vet/{vetId}/pet/{petId}/appointment")
    public ResponseEntity<AppointmentDto> createAppointment(@PathVariable(value = "vetId") long vetId,
                                                            @PathVariable(value = "petId") long petId,
                                                            @Valid @RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.ok().body(appointmentService.createAppointment(vetId, petId, appointmentDto));
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(){
        return ResponseEntity.ok().body(appointmentService.getAppointments());
    }

    @GetMapping("/appointment/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable("status") Status status){
        return ResponseEntity.ok().body(appointmentService.getAppointmentByStatus(status));
    }

    @PatchMapping("/appointment/{appointmentId}/status/{status}")
    public ResponseEntity<AppointmentDto> changeAppointmentStatus(@PathVariable("status") Status status, @PathVariable("appointmentId") long appointmentId){
        return ResponseEntity.ok().body(appointmentService.changeAppointmentStatus(appointmentId, status));
    }
}
