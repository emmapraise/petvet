package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Specialty;
import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.VetDto;
import com.emmapraise.petvet.repo.SpecialtyRepo;
import com.emmapraise.petvet.repo.VetRepo;
import com.emmapraise.petvet.service.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepo vetRepo;

    private final SpecialtyRepo specialtyRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<VetDto> getVets() {
        log.info("Retrieving all Vets");
        return vetRepo.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public VetDto getVet(long vetId) {
        log.info("Get Vet with this id {}", vetId);
        return mapToDto(vetRepo.findById(vetId).orElseThrow(()-> new IllegalStateException("Vet with the id dont exist")));
    }

    @Override
    public VetDto saveVet(VetDto vetDto) {
        log.info("Saving new vet");
        Vet vet = mapToEntity(vetDto);
        if (vetRepo.existsByEmail(vet.getEmail())) {
            throw new IllegalStateException("Email is taken");
        }
        return mapToDto(vetRepo.save(vet));
    }

    @Override
    public void addSpecialtyToVet(long vetId, long specialtyId){
        log.info("Add specialities to vet clinic ");
        Vet vet = vetRepo.findById(vetId).orElseThrow(()-> new IllegalStateException("No vet Found"));
        Specialty specialty = specialtyRepo.findById(specialtyId).orElseThrow(()-> new IllegalStateException("No Speciality found"));
        vet.getSpecialties().add(specialty);
    }

    @Override
    @Transactional
    public VetDto updateVet(long vetId, VetDto vetDto) {
        Vet vet = vetRepo.findById(vetId).orElseThrow(() -> new IllegalStateException("No Vet with the id " + vetId));
        vet.setAddress(vetDto.getAddress());
        vet.setName(vetDto.getName());
        vet.setPhone(vetDto.getPhone());
        vet.setPrice(vetDto.getPrice());
        return mapToDto(vetRepo.save(vet));
    }

    @Override
    public String deleteVet(long vetId) {
        if (vetRepo.existsById(vetId)) {
            vetRepo.deleteById(vetId);
        }
        throw new IllegalStateException("No Vet found");
    }

    private VetDto mapToDto(Vet vet) {
        return mapper.map(vet, VetDto.class);
    }

    private Vet mapToEntity(VetDto vetDto) {
        return mapper.map(vetDto, Vet.class);
    }
}
