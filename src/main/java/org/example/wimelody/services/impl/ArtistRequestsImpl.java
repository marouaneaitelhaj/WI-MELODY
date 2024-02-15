package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.ArtistRequestsStatus;
import org.example.wimelody.dto.artistRequests.ArtistRequestsReq;
import org.example.wimelody.entities.ArtistRequests;
import org.example.wimelody.entities.Fan;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.ArtistRequestsRepository;
import org.example.wimelody.repositories.FanRepository;
import org.example.wimelody.services.inter.ArtistRequestsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistRequestsImpl implements ArtistRequestsService {

    private final ArtistRequestsRepository artistRequestsRepository;

    private final FanRepository fanRepository;

    private ModelMapper modelMapper;

    @Override
    public ArtistRequests save(ArtistRequestsReq dtoMini) {
        Fan fan = fanRepository.findById(dtoMini.getFan_id()).orElseThrow(() -> new NotFoundEx("Fan Not Found"));
        ArtistRequests artistRequests = modelMapper.map(dtoMini, ArtistRequests.class);
        artistRequests.setFan(fan);
        artistRequests.setStatus(ArtistRequestsStatus.PENDING);
        return modelMapper.map(artistRequestsRepository.save(artistRequests), ArtistRequests.class);
    }

    @Override
    public ArtistRequests reject(Long artistRequests_id) {
        ArtistRequests artistRequests = artistRequestsRepository.findById(artistRequests_id).orElseThrow(() -> new NotFoundEx("Artist Request Not Found"));
        artistRequests.setStatus(ArtistRequestsStatus.REJECTED);
        return modelMapper.map(artistRequestsRepository.save(artistRequests), ArtistRequests.class);
    }

    @Override
    public ArtistRequests approve(Long artistRequests_id) {
        ArtistRequests artistRequests = artistRequestsRepository.findById(artistRequests_id).orElseThrow(() -> new NotFoundEx("Artist Request Not Found"));
        artistRequests.setStatus(ArtistRequestsStatus.APPROVED);
        return modelMapper.map(artistRequestsRepository.save(artistRequests), ArtistRequests.class);
    }

    @Override
    public ArtistRequests findById(Long artistRequests_id) {
        return null;
    }

    @Override
    public List<ArtistRequestsService> findAll() {
        return null;
    }
}
