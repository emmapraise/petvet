package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Owner;
import com.emmapraise.petvet.payload.OwnerDto;
import com.emmapraise.petvet.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping("/owner/{email}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable(value = "email") String email){
        return ResponseEntity.ok().body(ownerService.getOwner(email));
    }
    @PostMapping("/owner")
    public ResponseEntity<OwnerDto> saveOwner(@RequestBody OwnerDto ownerDto){
        return ResponseEntity.ok().body(ownerService.saveOwner(ownerDto));
    }

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners(){
        return ResponseEntity.ok().body(ownerService.getOwners());
    }

    @DeleteMapping("/owner/{email}")
    public ResponseEntity<String> deleteOwner(@PathVariable("email") String email){
        return ResponseEntity.ok().body(ownerService.deleteOwner(email));
    }
}
