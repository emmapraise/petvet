package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.PetOwner;
import com.emmapraise.petvet.payload.DashboardDto;
import com.emmapraise.petvet.repo.AppointmentRepo;
import com.emmapraise.petvet.repo.OwnerRepo;
import com.emmapraise.petvet.repo.PetRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
    private final AppointmentRepo appointmentRepo;
    private final OwnerRepo ownerRepo;

    private final PetRepo petRepo;

    @GetMapping("/dashboard/user/{userId}")
    public ResponseEntity<DashboardDto> getUser(@PathVariable("userId") long userId) {
        PetOwner petOwner = ownerRepo.findByUserId(userId).orElseThrow(() -> new IllegalStateException("No pet owner found"));
        ;
        int appointmentCount = appointmentRepo.findAppointmentsByPet_PetOwnerOrderByCreatedAtDesc(petOwner).size();
        int petCount = petRepo.findPetsByPetOwner_UserId(userId).size();
        DashboardDto dashboardDto = new DashboardDto(appointmentCount, petCount);
        return ResponseEntity.ok().body(dashboardDto);
    }
}
