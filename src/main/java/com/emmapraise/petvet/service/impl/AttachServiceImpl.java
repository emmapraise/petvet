package com.emmapraise.petvet.service.impl;

import com.emmapraise.petvet.entity.Attach;
import com.emmapraise.petvet.repo.AttachRepo;
import com.emmapraise.petvet.service.AttachService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AttachServiceImpl implements AttachService {

    private final AttachRepo attachRepo;

    @Override
    public Attach upload(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid sequence " + fileName);
            }
            String path = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/download/")
                    .path(fileName)
                    .toUriString();
            Attach attach = new Attach(fileName, path, file.getContentType(), file.getBytes());
            return attachRepo.save(attach);
        } catch (Exception e) {
            throw new Exception("Could not save file " + fileName);
        }
    }

    @Override
    public Attach getImage(String attachName) throws Exception {
        log.info("Getting the right document out with name {}", attachName);
        return attachRepo.findByName(attachName);
    }
}
