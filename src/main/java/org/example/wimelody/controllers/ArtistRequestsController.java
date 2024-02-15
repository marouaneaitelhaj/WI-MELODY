package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.artistRequests.ArtistRequestsReq;
import org.example.wimelody.entities.ArtistRequests;
import org.example.wimelody.services.BaseService;
import org.example.wimelody.services.inter.ArtistRequestsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artistrequests")
@RequiredArgsConstructor
public class ArtistRequestsController  {
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ArtistRequestsReq dtoMini) {
        return null;
    }

    @PostMapping("/reject/{artistRequests_id}")
    public ResponseEntity<?> reject(@PathVariable Long artistRequests_id) {
        return null;
    }

    @PostMapping("/approve/{artistRequests_id}")
    public ResponseEntity<?> approve(@PathVariable Long artistRequests_id) {
        return null;
    }


    public ResponseEntity<?> findById(@PathVariable Long artistRequests_id) {
        return null;
    }


    public List<ArtistRequestsService> findAll() {
        return null;
    }
}
