package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.PetOwner;
import com.emmapraise.petvet.payload.OwnerDto;
import com.emmapraise.petvet.repo.OwnerRepo;
import com.emmapraise.petvet.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepo ownerRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<OwnerDto> getOwners() {
        log.info("Retrieving all Owners");
        return ownerRepo.findAll().stream().map(this::mapToDto).toList();
    }

//    @Override
//    public OwnerDto getOwner(String email) {
//        log.info("Get Owner with email {}", email);
//        if (ownerRepo.existsByEmail(email)) {
//            return mapToDto(ownerRepo.findByEmail(email));
//        }
//        throw new IllegalStateException("Owner not found");
//    }

    @Override
    public OwnerDto saveOwner(OwnerDto ownerDto, AppUser currentUser) {
        log.info("Saving Owner entity to the database");
        PetOwner petOwner = mapToEntity(ownerDto);
        petOwner.setUser(currentUser);
        return mapToDto(ownerRepo.save(petOwner));
    }

//    @Override
//    @Transactional
//    public OwnerDto updateOwner(long ownerId, OwnerDto ownerDto) {
//        log.info("Updating Owner profile of id {}", ownerId);
//        PetOwner petOwner = ownerRepo.findById(ownerId).orElseThrow(() -> new IllegalStateException(
//                "No Owner with the id " + ownerId + " found"));
//        petOwner.setFirstName(ownerDto.getFirstName());
//        petOwner.setLastName(ownerDto.getLastName());
//        petOwner.setPhone(ownerDto.getPhone());
//        petOwner.setAddress(ownerDto.getAddress());
//        petOwner.setCity(ownerDto.getCity());
//
//        return mapToDto(ownerRepo.save(petOwner));
//
//    }

    @Override
    public String deleteOwner(long ownerId) {
        log.info("Deleting user with the id {}", ownerId);
        if (ownerRepo.existsById(ownerId)) {
            ownerRepo.deleteById(ownerId);
            return "User deleted";
        }
        throw new IllegalStateException("User not found");
    }

    private OwnerDto mapToDto(PetOwner petOwner) {
        return mapper.map(petOwner, OwnerDto.class);
    }

    private PetOwner mapToEntity(OwnerDto ownerDto) {
        return mapper.map(ownerDto, PetOwner.class);
    }
}
