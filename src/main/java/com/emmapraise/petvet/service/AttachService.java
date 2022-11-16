package com.emmapraise.petvet.service;

import com.emmapraise.petvet.entity.Attach;
import org.springframework.web.multipart.MultipartFile;

public interface AttachService {
    Attach upload(MultipartFile file) throws Exception;

    Attach getImage(long imageId) throws Exception;
}
