package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.config.UserAuthProvider;
import org.example.wimelody.dto.user.UserCredential;
import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.inter.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthController {

        private  final UserService userService;

        private  final UserAuthProvider userAuthProvider;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserCredential userCredential) {
        UserDtoRsp userDtoRsp = userService.login(userCredential);
        userDtoRsp.setToken(userAuthProvider.createToken(userDtoRsp));
        return ResponseEntity.ok(userDtoRsp);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDtoReq userCredential) {
        return ResponseEntity.ok(userService.save(userCredential));
    }
}
