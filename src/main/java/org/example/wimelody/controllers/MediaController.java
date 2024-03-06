package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.media.MediaDtoReq;
import org.example.wimelody.dto.media.MediaDtoRsp;
import org.example.wimelody.services.inter.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/media")
@RequiredArgsConstructor
public class MediaController  {

    private final MediaService mediaService;

    public ResponseEntity<?> save(MediaDtoReq mediaDtoReq) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", mediaService.save(mediaDtoReq));
        response.put("message", "Media created successfully");
        return ResponseEntity.ok(response);
    }


    public ResponseEntity<?> update(MediaDtoReq mediaDtoReq, Long aLong) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", mediaService.update(mediaDtoReq, aLong));
        response.put("message", "Media updated successfully");
        return ResponseEntity.ok(response);

    }


    public ResponseEntity<?> delete(Long aLong) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", mediaService.delete(aLong));
        response.put("message", "Media deleted successfully");
        return ResponseEntity.ok(response);
    }


    public ResponseEntity<?> findById(Long aLong) {

        return ResponseEntity.ok(mediaService.findById(aLong));
    }


    public List<MediaDtoRsp> findAll() {

        return mediaService.findAll();
    }
}
