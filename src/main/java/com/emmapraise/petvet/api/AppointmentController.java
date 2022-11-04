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

    @PostMapping("/vet/{vetId}/pet/{petId}/appointment")
    public ResponseEntity<AppointmentDto> createAppointment(@PathVariable(value = "vetId") long vetId,
                                                            @PathVariable(value = "petId") long petId,
                                                            @Valid @RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.ok().body(appointmentService.createAppointment(vetId, petId, appointmentDto));
    }
}
