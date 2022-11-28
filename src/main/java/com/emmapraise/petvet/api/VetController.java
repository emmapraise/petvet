package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.payload.SpecialityToVetForm;
import com.emmapraise.petvet.payload.VetDto;
import com.emmapraise.petvet.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class VetController {
    private final VetService vetService;

    @GetMapping("/vet/all")
    public ResponseEntity<List<VetDto>> getVets() {
        return ResponseEntity.ok().body(vetService.getVets());
    }

    @PostMapping("/vet")
    public ResponseEntity<VetDto> saveVet(@RequestParam("coverImage") MultipartFile coverImage,
                                          @RequestParam("logo") MultipartFile logo,
                                          @RequestParam("document") MultipartFile document,
                                          @ModelAttribute("vetDto") VetDto vetDto, BindingResult result) throws Exception {
        return ResponseEntity.ok().body(vetService.saveVet(vetDto,  coverImage, logo, document));
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
