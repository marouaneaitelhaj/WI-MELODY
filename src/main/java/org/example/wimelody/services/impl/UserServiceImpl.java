package org.example.wimelody.services.impl;

import java.util.List;
import java.util.Optional;

import org.example.wimelody.dto.user.UserCredential;
import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.User;
import org.example.wimelody.exceptions.NotFoundExceprion;
import org.example.wimelody.repositories.UserRepository;
import org.example.wimelody.services.inter.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Override
    public UserDtoRsp save(UserDtoReq dtoMini) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public UserDtoRsp update(UserDtoReq dtoMini, Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public UserDtoRsp findOne(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<UserDtoRsp> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<UserDtoRsp> Login(UserCredential userCredential) {
        User user = userRepository.findByUsername(userCredential.getUsername()).orElse(
                userRepository.findByEmail(userCredential.getEmail()).orElseThrow( () -> new NotFoundExceprion("User not found")));
        if (passwordEncoder.matches(userCredential.getPassword(), user.getPassword())) {
            return Optional.of(modelMapper.map(user, UserDtoRsp.class));
        } else {
            throw new NotFoundExceprion("Password not match");
        }
    }

}
