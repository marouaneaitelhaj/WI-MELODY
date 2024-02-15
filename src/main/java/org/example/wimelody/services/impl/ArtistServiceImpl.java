package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.dto.artist.ArtistDtoReq;
import org.example.wimelody.dto.artist.ArtistDtoRsp;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.ArtistRepository;
import org.example.wimelody.services.inter.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    @Override
    public ArtistDtoRsp save(ArtistDtoReq dtoMini) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ArtistDtoRsp update(ArtistDtoReq dtoMini, UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArtistDtoRsp findById(UUID f) {
        return modelMapper.map(artistRepository.findById(f).orElseThrow(() -> new NotFoundEx("Artist Not Found")), ArtistDtoRsp.class);
    }

    @Override
    public List<ArtistDtoRsp> findAll() {
        return artistRepository.findAll().stream().map(artist -> modelMapper.map(artist, ArtistDtoRsp.class)).collect(Collectors.toList());
    }
    
}
