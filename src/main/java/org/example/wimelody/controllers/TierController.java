package org.example.wimelody.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.dto.tier.TierDtoRsp;
import org.example.wimelody.services.impl.TierServiceImpl;
import org.example.wimelody.services.inter.TierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tier")
@RequiredArgsConstructor
public class TierController  {


    public ResponseEntity<?> save(TierDtoReq tierDtoReq) {
        return null;
    }


    public ResponseEntity<?> update(TierDtoReq tierDtoReq, Long aLong) {
        return null;
    }


    public Boolean delete(Long aLong) {
        return null;
    }


    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }


    public List<TierDtoRsp> findAll() {
        return null;
    }
}
