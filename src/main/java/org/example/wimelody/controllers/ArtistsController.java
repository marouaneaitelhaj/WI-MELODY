package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.services.inter.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/artists")
@RequiredArgsConstructor
public class ArtistsController {

    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<?> getArtists() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArtist(@PathVariable UUID id) {
        return ResponseEntity.ok(artistService.findById(id));
    }

}
