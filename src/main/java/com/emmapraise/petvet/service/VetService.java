package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.VetDto;

import java.util.List;

public interface VetService {
    List<Vet> getVets();

    VetDto saveVet(VetDto vetDto);

    VetDto getVet(long vetId);

    void addSpecialtyToVet(long vetId, long specialtyId);

    VetDto updateVet(long vetId, VetDto vetDto);

    String deleteVet(long vetId);
}
