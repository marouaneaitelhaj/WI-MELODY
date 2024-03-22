package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.services.impl.DbUserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final DbUserServiceImpl dbUserService;

    @PostMapping("/updateBannerProfile")
    public ResponseEntity<?> updateBannerProfile(@RequestBody DBUser banner) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Banner updated successfully");
        response.put("data", dbUserService.updatebanner(banner.getBanner()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateProfilePicture")
    public ResponseEntity<?> updateProfilePicture(@RequestBody DBUser profilePicture) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "profilePicture updated successfully");
        response.put("data", dbUserService.updateprofilePicture(profilePicture.getProfilePicture()));
        return ResponseEntity.ok(response);
    }
}
