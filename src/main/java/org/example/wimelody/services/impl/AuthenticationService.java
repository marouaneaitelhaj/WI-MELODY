package org.example.wimelody.services.impl;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.wimelody.config.JwtService;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.enums.Role;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.reqrsp.AuthenticationRequest;
import org.example.wimelody.reqrsp.AuthenticationResponse;
import org.example.wimelody.reqrsp.RegisterRequest;
import org.example.wimelody.services.inter.AuthenticationServiceInterface;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class AuthenticationService implements AuthenticationServiceInterface {

    private  final DBUserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private final JwtService jwtService;


    private  final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = DBUser.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    @Override
    public DBUser getUser(String name) {
        return userRepository.findByUsername(name).orElseThrow(() -> new RuntimeException("User not found"));
    }
}