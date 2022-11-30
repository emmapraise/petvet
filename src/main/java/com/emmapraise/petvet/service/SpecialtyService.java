package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty addSpecialty(Specialty specialty);
    List<Specialty> getSpecialities();
    String deleteSpeciality(long specialtyId);
}
