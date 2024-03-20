package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.artistRequests.ArtistRequestsReq;
import org.example.wimelody.services.inter.ArtistRequestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/artistrequests")
@RequiredArgsConstructor
public class ArtistRequestsController  {

    private final ArtistRequestsService artistRequestsService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ArtistRequestsReq dtoMini) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", artistRequestsService.save(dtoMini));
        response.put("message", "ArtistRequests created successfully");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/reject/{artistRequests_id}")
    public ResponseEntity<?> reject(@PathVariable Long artistRequests_id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", artistRequestsService.reject(artistRequests_id));
        response.put("message", "ArtistRequests rejected successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/approve/{artistRequests_id}")
    public ResponseEntity<?> approve(@PathVariable Long artistRequests_id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", artistRequestsService.approve(artistRequests_id));
        response.put("message", "ArtistRequests approved successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{artistRequests_id}")
    public ResponseEntity<?> findById(@PathVariable Long artistRequests_id) {

        return ResponseEntity.ok(artistRequestsService.findById(artistRequests_id));
    }

    @GetMapping
    public List<?> findAll() {
        return artistRequestsService.findAll();
    }
}
