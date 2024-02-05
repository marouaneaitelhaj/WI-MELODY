package org.example.wimelody.services.impl;

import java.util.List;

import org.example.wimelody.dto.user.UserCredential;
import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.Person;
import org.example.wimelody.exceptions.NotFoundException;
import org.example.wimelody.repositories.UserRepository;
import org.example.wimelody.services.inter.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Override
    public UserDtoRsp save(UserDtoReq dtoMini) {
        Person person = modelMapper.map(dtoMini, Person.class);
        person.setPassword(passwordEncoder.encode(dtoMini.getPassword()));
        return modelMapper.map(userRepository.save(person), UserDtoRsp.class);
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
    public UserDtoRsp login(UserCredential userCredential) {
        Person person = userRepository.findByEmail(userCredential.getEmail()).orElseThrow(
                () -> new NotFoundException("User with email " + userCredential.getEmail() + " not found"));
        if (passwordEncoder.matches(userCredential.getPassword(), person.getPassword())) {
            return modelMapper.map(person, UserDtoRsp.class);
        } else {
            throw new NotFoundException("Password not match");
        }
    }

}
