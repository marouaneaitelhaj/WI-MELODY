package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.ArtistRequestsStatus;
import org.example.wimelody.dto.artistRequests.ArtistRequestsReq;
import org.example.wimelody.entities.ArtistRequests;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.ArtistRequestsRepository;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.services.inter.ArtistRequestsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistRequestsServiceImpl implements ArtistRequestsService {

    private final ArtistRequestsRepository artistRequestsRepository;

    private final DBUserRepository dbUserRepository;

    private final ModelMapper modelMapper;

    @Override
    public ArtistRequests save(ArtistRequestsReq dtoMini) {
        DBUser fan = dbUserRepository.findById(dtoMini.getFan_id()).orElseThrow(() -> new NotFoundEx("Fan not found"));
        ArtistRequests artistRequests = modelMapper.map(dtoMini, ArtistRequests.class);
        artistRequests.setRequestDate(java.time.LocalDate.now());
        artistRequests.setFan(fan);
        artistRequests.setStatus(ArtistRequestsStatus.PENDING);
        return artistRequestsRepository.save(artistRequests);
    }

    @Override
    public ArtistRequests reject(Long artistRequests_id) {
        ArtistRequests artistRequests = artistRequestsRepository.findById(artistRequests_id).orElseThrow(() -> new IllegalArgumentException("Artist Request not found"));
        artistRequests.setStatus(ArtistRequestsStatus.REJECTED);
        return artistRequestsRepository.save(artistRequests);
    }

    @Override
    public ArtistRequests approve(Long artistRequests_id) {

        ArtistRequests artistRequests = artistRequestsRepository.findById(artistRequests_id).orElseThrow(() -> new NotFoundEx("Artist Request not found"));
        artistRequests.setStatus(ArtistRequestsStatus.APPROVED);
        return artistRequestsRepository.save(artistRequests);
    }

    @Override
    public ArtistRequests findById(Long artistRequests_id) {

        return artistRequestsRepository.findById(artistRequests_id).orElseThrow(() -> new NotFoundEx("Artist Request not found"));
    }

    @Override
    public List<ArtistRequests> findAll() {
        return artistRequestsRepository.findAll().stream().toList();
    }
}
