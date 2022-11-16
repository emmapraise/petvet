package com.emmapraise.petvet.api;

import com.emmapraise.petvet.entity.Attach;
import com.emmapraise.petvet.payload.AttachDto;
import com.emmapraise.petvet.service.AttachService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AttachController {
    private final AttachService attachService;

    @PostMapping("/image/upload")
    public AttachDto uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
        Attach attach = attachService.upload(file);
        String downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/download/")
                .path(String.valueOf(attach.getId()))
                .toUriString();
        return new AttachDto(attach.getId(), attach.getName(), downloadURI, file.getContentType(), file.getSize());
    }

    @GetMapping("/download/{imageId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("imageId") long imageId) throws Exception{
        Attach attach = attachService.getImage(imageId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attach.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attach.getName()
                + "\"")
                .body(new ByteArrayResource(attach.getData()));
    }
}
