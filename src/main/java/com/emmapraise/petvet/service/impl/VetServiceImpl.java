package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.AppUser;
import com.emmapraise.petvet.entity.Attach;
import com.emmapraise.petvet.entity.Specialty;
import com.emmapraise.petvet.entity.Vet;
import com.emmapraise.petvet.payload.RegistrationRequest;
import com.emmapraise.petvet.payload.VetDto;
import com.emmapraise.petvet.repo.SpecialtyRepo;
import com.emmapraise.petvet.repo.VetRepo;
import com.emmapraise.petvet.service.AttachService;
import com.emmapraise.petvet.service.RegistrationService;
import com.emmapraise.petvet.service.VetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class VetServiceImpl implements VetService {

    private final VetRepo vetRepo;

    private final RegistrationService registrationService;

    private final AttachService attachService;

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
    public VetDto saveVet(VetDto vetDto, MultipartFile... files) throws Exception {
        log.info("Saving new vet");
        AppUser appUser = registrationService.register(new RegistrationRequest(
                vetDto.getFirstName(), vetDto.getLastName(),
                vetDto.getEmail(), vetDto.getPhone(), vetDto.getPassword(), vetDto.getRole()));
        Vet vet = mapToEntity(vetDto);
        vet.setUser(appUser);
        if (files[0] != null) {
            log.info("Uploading Cover image {}", files[0]);
            Attach coverImage=  attachService.upload(files[0]);
            vet.setCoverImage(coverImage);
        }
        if (files[1] != null) {
            log.info("Uploading Logo {}", files[1]);
            Attach logo=  attachService.upload(files[1]);
            vet.setLogo(logo);
        }
        if (files[2] != null) {
            log.info("Uploading Document {}", files[2]);
            Attach document = attachService.upload(files[2]);
            vet.setDocument(document);
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
//        vet.setPhone(vetDto.getPhone());
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
