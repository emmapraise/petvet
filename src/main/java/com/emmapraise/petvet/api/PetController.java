package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.PetType;
import com.emmapraise.petvet.payload.PetDto;
import com.emmapraise.petvet.service.PetCategoryService;
import com.emmapraise.petvet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PetController {

    private final PetService petService;
    private final PetCategoryService petCategoryService;

    @GetMapping("/pet/all")
    public ResponseEntity<List<PetDto>> getPets() {
        return ResponseEntity.ok().body(petService.getPets());
    }

    @GetMapping("/pet/owner/{ownerId}")
    public ResponseEntity<List<PetDto>> getPetsByOwner(@PathVariable("ownerId") long ownerId) {
        return ResponseEntity.ok().body(petService.getPetsByOwner(ownerId));
    }

    @PostMapping("/pet/owner/{ownerId}/category/{categoryName}")
    public ResponseEntity<PetDto> addPet(@PathVariable(value = "ownerId") long ownerId,
                                         @PathVariable(value = "categoryName") String categoryName,
                                         @Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok().body(petService.addPet(ownerId, categoryName, petDto));
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<PetDto> getPet(@PathVariable(value = "petId") long petId) {
        return ResponseEntity.ok().body(petService.getPet(petId));
    }

    @DeleteMapping("/pet/{petId}")
    public ResponseEntity<String> deletePet(@PathVariable(value = "petId") long petId) {
        return ResponseEntity.ok().body(petService.deletePet(petId));
    }

    @PutMapping("/pet/{petId}")
    public ResponseEntity<PetDto> updatePet(@PathVariable(value = "petId") long petId,
                                            @Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok().body(petService.updatePet(petId, petDto));
    }

    @PostMapping("/pet_category")
    public ResponseEntity<PetType> addPetCategory(@RequestBody PetType pet_type) {
        return ResponseEntity.ok().body(petCategoryService.addPetCategory(pet_type));
    }

    @GetMapping("/pet_category/all")
    public ResponseEntity<List<PetType>> getPetCategories() {
        return ResponseEntity.ok().body(petCategoryService.getPetCategories());
    }
}
