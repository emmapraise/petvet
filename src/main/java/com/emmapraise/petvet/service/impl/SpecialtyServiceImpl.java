package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Specialty;
import com.emmapraise.petvet.repo.SpecialtyRepo;
import com.emmapraise.petvet.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecialtyServiceImpl implements SpecialtyService {

    public final SpecialtyRepo specialtyRepo;

    @Override
    public List<Specialty> getSpecialities() {
        return specialtyRepo.findAll();
    }

    @Override
    public Specialty addSpecialty(Specialty specialty) {
        return specialtyRepo.save(specialty);
    }

    @Override
    public String deleteSpeciality(long specialtyId) {
        if (specialtyRepo.existsById(specialtyId)) {
            specialtyRepo.deleteById(specialtyId);
            return "Specialty Deleted";
        }
        throw new IllegalStateException("No specialty found");
    }
}
