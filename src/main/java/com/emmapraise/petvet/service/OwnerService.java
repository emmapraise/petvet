package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Owner;
import com.emmapraise.petvet.payload.OwnerDto;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> getOwners();

    OwnerDto getOwner(String email);

    OwnerDto saveOwner(OwnerDto ownerDto);

    OwnerDto updateOwner(long ownerId, OwnerDto ownerDto);

    String deleteOwner(long ownerId);
}
