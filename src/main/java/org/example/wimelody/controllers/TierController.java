package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.dto.tier.TierDtoRsp;
import org.example.wimelody.services.inter.TierService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @PutMapping("/{aLong}")
    public ResponseEntity<?> update(@RequestBody TierDtoReq tierDtoReq, @PathVariable UUID aLong) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", tierService.update(tierDtoReq, aLong));
        response.put("message", "Tier updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{aLong}")
    public ResponseEntity<?> delete(@PathVariable UUID aLong) {
        return ResponseEntity.ok(tierService.delete(aLong));
    }

    @GetMapping("/{aLong}")
    @PreAuthorize("hasAnyAuthority('ROLE_FAN')")
    public ResponseEntity<?> findById(@PathVariable UUID aLong) {
        return ResponseEntity.ok(tierService.findById(aLong));
    }

    @GetMapping
    public List<TierDtoRsp> findAll() {

        return tierService.findAll();
    }
}
