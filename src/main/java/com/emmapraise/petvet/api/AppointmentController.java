package com.emmapraise.petvet.api;

import com.emmapraise.petvet.payload.AppointmentDto;
import com.emmapraise.petvet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/clinic/{clinicId}/client/{clientId}/appointment")
    public ResponseEntity<AppointmentDto> createAppointment(@PathVariable(value = "clinicId") long clinicId,
                                                            @PathVariable(value = "clientId") long clientId,
                                                            @Valid @RequestBody AppointmentDto appointmentDto){
        return ResponseEntity.ok().body(appointmentService.createAppointment(clinicId, clientId, appointmentDto));
    }
}
