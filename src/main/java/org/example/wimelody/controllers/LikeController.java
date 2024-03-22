package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.like.LikeDtoReq;
import org.example.wimelody.dto.like.LikeDtoRsp;
import org.example.wimelody.services.inter.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/api/v1/like")
@RequiredArgsConstructor
public class LikeController   {

    private  final LikeService likeService;
    @PostMapping
    @PreAuthorize("hasRole('ROLE_FAN')")
    public ResponseEntity<?> save(@RequestBody LikeDtoReq likeDtoReq) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Like created successfully");
        response.put("data", likeService.save(likeDtoReq));
        return ResponseEntity.ok(response);
    }
@PutMapping("/{aLong}")
    public ResponseEntity<?> update(LikeDtoReq likeDtoReq, @PathVariable Long aLong) {

        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Like updated successfully");
        response.put("data", likeService.update(likeDtoReq, aLong));
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{aLong}")
    public ResponseEntity<?> delete(@PathVariable Long aLong) {

        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Like deleted successfully");
        response.put("data", likeService.delete(aLong));
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> findById(Long aLong) {

        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Like found successfully");
        response.put("data", likeService.findById(aLong));
        return ResponseEntity.ok(response);
    }

    public List<LikeDtoRsp> findAll() {

        return likeService.findAll();
    }
}
