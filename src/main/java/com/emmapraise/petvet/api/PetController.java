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

    @PostMapping("/owner/{userId}/category/{categoryName}/pet")
    public ResponseEntity<Pets> addPet(@PathVariable(value = "userId") long userId,
                                       @PathVariable(value = "categoryName") String categoryName,
                                       @RequestBody Pets pets) {
        return ResponseEntity.ok().body(petService.addPet(userId, categoryName, pets));
    }
    @DeleteMapping("/pet/{petId}")
    public ResponseEntity<String> deletePet(@PathVariable(value = "petId") long petId){
        return ResponseEntity.ok().body(petService.deletePet(petId));
    }

    @PostMapping("/pet_category")
    public ResponseEntity<Pet_Category> addPetCategory(@RequestBody Pet_Category pet_category){
        return ResponseEntity.ok().body(petCategoryService.addPetCategory(pet_category));
    }

    @GetMapping("/pet_categories")
    public ResponseEntity<List<Pet_Category>> getPetCategories(){
        return ResponseEntity.ok().body(petCategoryService.getPetCategories());
    }
}
