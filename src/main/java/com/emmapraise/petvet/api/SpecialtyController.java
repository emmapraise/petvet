package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Specialty;
import com.emmapraise.petvet.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SpecialtyController {
    public final SpecialtyService specialtyService;

    @GetMapping("/specialty/all")
    public ResponseEntity<List<Specialty>> getSpecialites(){
        return ResponseEntity.ok().body(specialtyService.getSpecialities());
    }

    @PostMapping("/specialty")
    public ResponseEntity<Specialty> addSpecialty(@RequestBody Specialty specialty){
        return ResponseEntity.ok().body(specialtyService.addSpecialty(specialty));
    }

    @DeleteMapping("/specialty/{specialtyId}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable("specialtyId") long specialtyId){
        return ResponseEntity.ok().body(specialtyService.deleteSpeciality(specialtyId));
    }
}
