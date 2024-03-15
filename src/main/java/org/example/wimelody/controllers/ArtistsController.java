package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.impl.AuthenticationService;
import org.example.wimelody.services.inter.ArtistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/artists")
@RequiredArgsConstructor
public class ArtistsController {

    private final ArtistService artistService;

    private final AuthenticationService authenticationService;

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Page<UserDtoRsp>> getArtists(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam(defaultValue = "") String text) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserDtoRsp> artistsPage = artistService.findAll(pageable, text);
        return ResponseEntity.ok(artistsPage);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_FAN')")
    public ResponseEntity<?> getArtist(@PathVariable UUID id, Principal principal) {
        UserDtoRsp userDtoRsp = authenticationService.getUser(principal.getName());
        return ResponseEntity.ok(artistService.findById(id, userDtoRsp));
    }



}