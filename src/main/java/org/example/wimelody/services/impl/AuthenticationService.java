package org.example.wimelody.services.impl;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.wimelody.config.JwtService;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.ArtistRequests;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.enums.Role;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.ArtistRequestsRepository;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.reqrsp.AuthenticationRequest;
import org.example.wimelody.reqrsp.AuthenticationResponse;
import org.example.wimelody.reqrsp.RegisterRequest;
import org.example.wimelody.services.inter.AuthenticationServiceInterface;
import org.modelmapper.ModelMapper;
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

    private final ArtistRequestsRepository artistRequestsRepository;

    private final ModelMapper modelMapper;

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
        DBUser user = DBUser.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.FAN)
                .profilePicture(registerRequest.getProfilePicture())
                .email(registerRequest.getEmail())
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    @Override
    public UserDtoRsp getUser(String name) {
        DBUser user = userRepository.findByUsername(name).orElseThrow(() -> new NotFoundEx("User not found"));
        ArtistRequests artistRequests = artistRequestsRepository.findByFanId(user.getId()).orElse(null);
        //System.out.println(artistRequests);
        UserDtoRsp userDtoRsp = modelMapper.map(user, UserDtoRsp.class);
        userDtoRsp.setAlreadyRequested(artistRequests != null);
        return userDtoRsp;
    }
}
