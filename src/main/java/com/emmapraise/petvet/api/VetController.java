package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.VetDto;
import com.emmapraise.petvet.service.VetService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class VetController {
    private final VetService vetService;

    @GetMapping("/vet/all")
    public ResponseEntity<List<Vet>> getVets() {
        return ResponseEntity.ok().body(vetService.getVets());
    }

    @PostMapping("/vet")
    public ResponseEntity<VetDto> saveVet(@RequestBody VetDto vetDto) {
        return ResponseEntity.ok().body(vetService.saveVet(vetDto));
    }

    @PostMapping("/vet/specialtyToVet")
    public ResponseEntity<?> addSpecialtiesToVet(@RequestBody SpecialityToVetForm form ){
        vetService.addSpecialtyToVet(form.getVetId(), form.getSpecialtyId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/vet/{id}")
    public ResponseEntity<VetDto> getVet(@PathVariable("id") long vetId) {
        return ResponseEntity.ok().body(vetService.getVet(vetId));
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
@Getter
@Setter
class SpecialityToVetForm {
    private long vetId;
    private long specialtyId;
}
