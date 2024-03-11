package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.media.MediaDtoReq;
import org.example.wimelody.dto.media.MediaDtoRsp;
import org.example.wimelody.services.inter.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/media")
@RequiredArgsConstructor
public class MediaController  {

    private final MediaService mediaService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<MediaDtoReq> mediaDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", mediaService.save(mediaDtoReq));
        response.put("message", "Media created successfully");
        return ResponseEntity.ok(response);
    }

@PutMapping("/{media_id}")
    public ResponseEntity<?> update(MediaDtoReq mediaDtoReq, @PathVariable Long media_id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", mediaService.update(mediaDtoReq, media_id));
        response.put("message", "Media updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{media_id}")
    public ResponseEntity<?> delete(@PathVariable Long media_id) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", mediaService.delete(media_id));
        response.put("message", "Media deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{media_id}")
    public ResponseEntity<?> findById(@PathVariable Long media_id) {

        return ResponseEntity.ok(mediaService.findById(media_id));
    }

    @GetMapping("/pack/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ARTIST')")
    public List<MediaDtoRsp> findAllByPack(@PathVariable Long id) {
        return mediaService.findAllByPack(id);
    }

    @GetMapping
    public List<MediaDtoRsp> findAll() {

        return mediaService.findAll();
    }
}
