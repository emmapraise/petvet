package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.payload.OwnerDto;
import com.emmapraise.petvet.payload.RegistrationRequest;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> getOwners();

//    OwnerDto getOwner(String email);

//    OwnerDto updateOwner(long ownerId, OwnerDto ownerDto);

    OwnerDto saveOwner(OwnerDto ownerDto);

    String deleteOwner(long ownerId);
}
