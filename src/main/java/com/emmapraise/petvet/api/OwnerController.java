package com.emmapraise.petvet.api;

import com.emmapraise.petvet.payload.OwnerDto;
import com.emmapraise.petvet.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping("/owner/{email}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok().body(ownerService.getOwner(email));
    }

    @PostMapping("/owner")
    public ResponseEntity<OwnerDto> saveOwner(@RequestBody OwnerDto ownerDto) {
        return ResponseEntity.ok().body(ownerService.saveOwner(ownerDto));
    }

    @PutMapping("/owner/{ownerId}")
    public ResponseEntity<OwnerDto> updateOwner(@PathVariable("ownerId") long ownerId, @RequestBody OwnerDto ownerDto) {
        return ResponseEntity.ok().body(ownerService.updateOwner(ownerId, ownerDto));
    }

    @GetMapping("/owner/all")
    public ResponseEntity<List<OwnerDto>> getOwners() {
        return ResponseEntity.ok().body(ownerService.getOwners());
    }

    @DeleteMapping("/owner/{ownerId}")
    public ResponseEntity<String> deleteOwner(@PathVariable("ownerId") long ownerId) {
        return ResponseEntity.ok().body(ownerService.deleteOwner(ownerId));
    }
}
