package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.user.UserCredential;
import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.reqrsp.AuthenticationRequest;
import org.example.wimelody.reqrsp.AuthenticationResponse;
import org.example.wimelody.reqrsp.RegisterRequest;
import org.example.wimelody.services.impl.AuthenticationService;
import org.example.wimelody.services.inter.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private  final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }


    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }



    @PostMapping("/user")
    public ResponseEntity<?> currentUserName(Principal principal) {
        if (principal == null) {
            // return that the user is not authenticated
            return ResponseEntity.status(401).body("User not authenticated");
        }
        return ResponseEntity.ok(authenticationService.getUser(principal.getName()));
    }
}
