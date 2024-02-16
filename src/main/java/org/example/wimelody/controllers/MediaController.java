package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.media.MediaDtoReq;
import org.example.wimelody.dto.media.MediaDtoRsp;
import org.example.wimelody.services.inter.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/media")
@RequiredArgsConstructor
public class MediaController  {

    public ResponseEntity<?> save(MediaDtoReq mediaDtoReq) {
        return null;
    }


    public ResponseEntity<?> update(MediaDtoReq mediaDtoReq, Long aLong) {
        return null;
    }


    public Boolean delete(Long aLong) {
        return null;
    }


    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }


    public List<MediaDtoRsp> findAll() {
        return null;
    }
}
