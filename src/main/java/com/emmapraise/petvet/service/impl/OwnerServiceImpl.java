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
        return mapToDto(ownerRepo.findByEmail(email));
    }

    @Override
    public OwnerDto saveOwner(OwnerDto ownerDto) {
        return null;
    }

    @Override
    public String deleteOwner(String email) {
        return null;
    }

    private OwnerDto mapToDto(Owner owner){
        return  mapper.map(owner, OwnerDto.class);
    }

    private Owner mapToEntity(OwnerDto ownerDto){
        return mapper.map(ownerDto, Owner.class);
    }
}
