package org.example.wimelody.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @RequestMapping("/hello")
    public ResponseEntity<?> heloo() {
        return ResponseEntity.ok("Hello World");
    }
}
