package com.emmapraise.petvet.api;

import com.emmapraise.petvet.Domain.Pet_Category;
import com.emmapraise.petvet.Domain.Pets;
import com.emmapraise.petvet.service.PetCategoryService;
import com.emmapraise.petvet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PetController {

    private final PetService petService;
    private final PetCategoryService petCategoryService;

    @GetMapping("/pets")
    public ResponseEntity<List<Pets>> getPets(){
        return ResponseEntity.ok().body(petService.getPets());
    }

    @PostMapping("/pet_category")
    public ResponseEntity<Pet_Category> addPetCategory(@RequestBody Pet_Category pet_category){
        return ResponseEntity.ok().body(petCategoryService.addPetCategory(pet_category));
    }
}
