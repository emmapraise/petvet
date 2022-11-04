package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.VetDto;
import com.emmapraise.petvet.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VetController {
    private final VetService vetService;

    @GetMapping("/vets")
    public ResponseEntity<List<Vet>> getVets() {
        return ResponseEntity.ok().body(vetService.getVets());
    }

    @PostMapping("/vet")
    public ResponseEntity<VetDto> saveVet(@RequestBody VetDto vetDto) {
        return ResponseEntity.ok().body(vetService.saveVet(vetDto));
    }

    @GetMapping("/vet/{email}")
    public ResponseEntity<VetDto> getVet(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(vetService.getVet(email));
    }

    @PutMapping("/vet/{vetId}")
    public ResponseEntity<VetDto> updateVet(@PathVariable("vetId") long vetId, @RequestBody VetDto vetDto) {
        return ResponseEntity.ok().body(vetService.updateVet(vetId, vetDto));
    }

    @DeleteMapping("/vet/{vetId}")
    public ResponseEntity<String> deleteVet(@PathVariable("vetId") long vetId) {
        return ResponseEntity.ok().body(vetService.deleteVet(vetId));
    }
}
