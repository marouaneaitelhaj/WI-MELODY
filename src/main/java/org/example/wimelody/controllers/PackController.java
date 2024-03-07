package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.services.inter.PackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pack")
@RequiredArgsConstructor
public class PackController  {


    private final PackService packService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PackDtoReq packDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", packService.save(packDtoReq));
        response.put("message", "Pack created successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{aLong}")
    public ResponseEntity<?> update(@RequestBody PackDtoReq packDtoReq, @PathVariable Long aLong) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", packService.update(packDtoReq, aLong));
        response.put("message", "Pack updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{aLong}")
    public ResponseEntity<?> delete(@PathVariable Long aLong) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", packService.delete(aLong));
        response.put("message", "Pack deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{aLong}")
    public ResponseEntity<?> findById(@PathVariable Long aLong) {

        return ResponseEntity.ok(packService.findById(aLong));
    }

    @GetMapping
    public List<PackDtoRsp> findAll() {
        return packService.findAll();
    }

    @GetMapping("/tier/{id}")
    private List<PackDtoRsp> findAllByTier(@PathVariable String id) {
        return packService.findAllByTier(Long.parseLong(id));
    }
}
