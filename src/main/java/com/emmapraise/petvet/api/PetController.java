package com.emmapraise.petvet.api;

import com.emmapraise.petvet.Domain.Pets;
import com.emmapraise.petvet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PetController {

    private final PetService petService;

    @GetMapping("/pets")
    public ResponseEntity<List<Pets>> getPets(){
        return ResponseEntity.ok().body(petService.getPets());
    }
}
