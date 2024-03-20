package org.example.wimelody.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.impl.AuthenticationService;
import org.example.wimelody.services.inter.PackService;
import org.example.wimelody.services.inter.TierService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pack")
@RequiredArgsConstructor
public class PackController  {


    private final PackService packService;

    private  final TierService tierService;

    private final AuthenticationService authenticationService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ARTIST')")
    public ResponseEntity<?> save(@RequestBody PackDtoReq packDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", packService.save(packDtoReq));
        response.put("message", "Pack created successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{aLong}")
    @PreAuthorize("hasRole('ROLE_ARTIST')")
    public ResponseEntity<?> update(@RequestBody PackDtoReq packDtoReq, @PathVariable Long aLong) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", packService.update(packDtoReq, aLong));
        response.put("message", "Pack updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{aLong}")
    @PreAuthorize("hasRole('ROLE_ARTIST')")
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
    @PreAuthorize("hasRole('ROLE_FAN') or hasRole('ROLE_ARTIST')")
    public List<PackDtoRsp> findAll(Principal principal) {
        UserDtoRsp userDtoRsp = authenticationService.getUser(principal.getName());
        System.out.println(userDtoRsp);
        return packService.findAll(userDtoRsp);
    }


    @GetMapping("/artist/{id}")
    @PreAuthorize("hasRole('ROLE_FAN')")
    public List<PackDtoRsp> findAllByArtist(Principal principal, @PathVariable UUID id) {
        UserDtoRsp userDtoRsp = authenticationService.getUser(principal.getName());
        return packService.findAllByArtist(id, userDtoRsp);
    }

    @GetMapping("/tier/{id}")
    public List<PackDtoRsp> findAllByTier(@PathVariable UUID id) {
        return packService.findAllByTier(id);
    }


}
