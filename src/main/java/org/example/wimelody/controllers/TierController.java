package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.dto.tier.TierDtoRsp;
import org.example.wimelody.services.inter.TierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tier")
@RequiredArgsConstructor
public class TierController  {

    private final TierService tierService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TierDtoReq tierDtoReq) {
        return ResponseEntity.ok(tierService.save(tierDtoReq));
    }


    public ResponseEntity<?> update(TierDtoReq tierDtoReq, Long aLong) {

        return ResponseEntity.ok(tierService.update(tierDtoReq, aLong));
    }


    public ResponseEntity<?> delete(Long aLong) {

        return ResponseEntity.ok(tierService.delete(aLong));
    }


    public ResponseEntity<?> findById(Long aLong) {

        return ResponseEntity.ok(tierService.findById(aLong));
    }


    public List<TierDtoRsp> findAll() {

        return tierService.findAll();
    }
}
