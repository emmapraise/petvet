package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.VetDto;

import java.util.List;

public interface VetService {
    List<VetDto> getVets();

    VetDto saveVet(VetDto vetDto);

    VetDto getVet(String email);

    VetDto updateVet(long vetId, VetDto vetDto);

    String deleteVet(long vetId);
}
