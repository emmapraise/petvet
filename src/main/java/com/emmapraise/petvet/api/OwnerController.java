package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Owner;
import com.emmapraise.petvet.payload.OwnerDto;
import com.emmapraise.petvet.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OwnerController {
    private final OwnerService ownerService;

    @Operation(summary = "Get Owners", description = "Get all the owners", tags = "Owners")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the owners", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = OwnerDto.class)),
            }),
            @ApiResponse(responseCode = "404", description = "No Owner", content = @Content)
    })
    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners() {
        return ResponseEntity.ok().body(ownerService.getOwners());
    }

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


    @DeleteMapping("/owner/{ownerId}")
    public ResponseEntity<String> deleteOwner(@PathVariable("ownerId") long ownerId) {
        return ResponseEntity.ok().body(ownerService.deleteOwner(ownerId));
    }
}
