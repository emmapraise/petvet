package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.VetDto;
import com.emmapraise.petvet.repo.VetRepo;
import com.emmapraise.petvet.service.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service @Transactional @Slf4j @RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepo vetRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<Vet> getVets() {
        log.info("Retrieving all Vets");
        return vetRepo.findAll();
    }

    @Override
    public VetDto getVet(String email) {
        log.info("Get Vet with this email {}", email);
        if (vetRepo.existsByEmail(email)){
            return mapToDto(vetRepo.findByEmail(email));
        }
        throw new IllegalStateException("No Vet found");
    }

    @Override
    public VetDto saveVet(VetDto vetDto) {
        log.info("Saving new vet");
        Vet vet = mapToEntity(vetDto);
        if (vetRepo.existsByEmail(vet.getEmail())){
            throw new IllegalStateException("Email is taken");
        }
        return mapToDto(vetRepo.save(vet));
    }

    @Override
    public String deleteVet(String email) {
        if (vetRepo.existsByEmail(email)){
            vetRepo.deleteByEmail(email);
        }
        throw new IllegalStateException("No Vet found");
    }

    private VetDto mapToDto(Vet vet){
        return  mapper.map(vet, VetDto.class);
    }

    private Vet mapToEntity(VetDto vetDto){
        return mapper.map(vetDto, Vet.class);
    }
}
