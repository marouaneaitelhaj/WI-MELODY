package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;

import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.enums.Role;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.services.inter.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final DBUserRepository artistRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDtoRsp save(UserDtoReq dtoMini) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public UserDtoRsp update(UserDtoReq dtoMini, UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public UserDtoRsp findById(UUID f) {
        return modelMapper.map(artistRepository.findByIdAndRole(f, Role.ARTIST).orElseThrow(() -> new NotFoundEx("Artist Not Found")), UserDtoRsp.class);
    }

    @Override
    public List<UserDtoRsp> findAll() {
        return artistRepository.findAllByRole(Role.ARTIST).stream().map(artist -> modelMapper.map(artist, UserDtoRsp.class)).collect(Collectors.toList());
    }
    
}
