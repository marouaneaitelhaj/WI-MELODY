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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tier")
@RequiredArgsConstructor
public class TierController  {

    private final TierService tierService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TierDtoReq tierDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", tierService.save(tierDtoReq));
        response.put("message", "Tier created successfully");
        return ResponseEntity.ok(response);
    }


    public ResponseEntity<?> update(TierDtoReq tierDtoReq, Long aLong) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", tierService.update(tierDtoReq, aLong));
        response.put("message", "Tier updated successfully");
        return ResponseEntity.ok(response);
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
