package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Owner;
import com.emmapraise.petvet.payload.OwnerDto;
import com.emmapraise.petvet.repo.OwnerRepo;
import com.emmapraise.petvet.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepo ownerRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<Owner> getOwners() {
        log.info("Retrieving all Owners");
        return ownerRepo.findAll();
    }

    @Override
    public OwnerDto getOwner(String email) {
        log.info("Get Owner with email {}", email);
        if (ownerRepo.existsByEmail(email)){
            return mapToDto(ownerRepo.findByEmail(email));
        }
        throw new IllegalStateException("Owner not found");
    }

    @Override
    public OwnerDto saveOwner(OwnerDto ownerDto) {
        log.info("Saving Owner entity to the database");
        Owner owner = mapToEntity(ownerDto);
        if (ownerRepo.existsByEmail(owner.getEmail())){
            throw new IllegalStateException("Email taken");
        }
        return mapToDto(ownerRepo.save(owner));
    }

    @Override
    public String deleteOwner(String email) {
        log.info("Deleting user with the email {}", email);
        if (ownerRepo.existsByEmail(email)){
            ownerRepo.deleteByEmail(email);
            return "User deleted";
        }
        throw new IllegalStateException("User not found");
    }

    private OwnerDto mapToDto(Owner owner){
        return  mapper.map(owner, OwnerDto.class);
    }

    private Owner mapToEntity(OwnerDto ownerDto){
        return mapper.map(ownerDto, Owner.class);
    }
}
