package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.services.inter.PackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/pack")
@RequiredArgsConstructor
public class PackController  {

    public ResponseEntity<?> save(PackDtoReq packDtoReq) {
        return null;
    }


    public ResponseEntity<?> update(PackDtoReq packDtoReq, Long aLong) {
        return null;
    }


    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }


    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }


    public List<PackDtoRsp> findAll() {
        return null;
    }
}
