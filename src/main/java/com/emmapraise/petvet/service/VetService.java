package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.VetDto;

import java.util.List;

public interface VetService {
    List<Vet> getVets();

    VetDto saveVet(VetDto vetDto);

    VetDto getVet(String email);

    String deleteVet(String email);
}
