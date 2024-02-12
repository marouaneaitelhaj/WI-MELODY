package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.services.impl.ArtistServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artists")
@RequiredArgsConstructor
public class ArtistsController {

    public  final ArtistServiceImpl artistService;
    @GetMapping
    public ResponseEntity<?> getArtists() {
        return ResponseEntity.ok(artistService.findAll());
    }
}
