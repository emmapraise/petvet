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
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/appointment/vet/{vetId}/pet/{petId}")
    public ResponseEntity<AppointmentDto> createAppointment(@PathVariable(value = "vetId") long vetId,
                                                            @PathVariable(value = "petId") long petId,
                                                            @Valid @RequestBody AppointmentDto appointmentDto) {
        return ResponseEntity.ok().body(appointmentService.createAppointment(petId, vetId, appointmentDto));
    }

    @GetMapping("/appointment/all")
    public ResponseEntity<List<AppointmentDto>> getAppointments(){
        return ResponseEntity.ok().body(appointmentService.getAppointments());
    }

    @GetMapping("/appointment/{status}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByStatus(@PathVariable("status") Status status){
        return ResponseEntity.ok().body(appointmentService.getAppointmentByStatus(status));
    }

    @GetMapping("/appointment/vet/{userId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentByUser(@PathVariable("userId") long userId){
        return ResponseEntity.ok().body(appointmentService.getAppointmentsByUser(userId));
    }

    @GetMapping("/appointment/{appointmentId}/accept")
    public ResponseEntity<AppointmentDto> changeAppointmentStatus(@RequestParam("status") Status status, @PathVariable("appointmentId") long appointmentId){
        return ResponseEntity.ok().body(appointmentService.changeAppointmentStatus(appointmentId, status));
    }

    @GetMapping("/appointment/owner/{ownerId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByOwner(@PathVariable("ownerId") long ownerId){
        return ResponseEntity.ok().body(appointmentService.getAppointmentsByOwner(ownerId));
    }
}
