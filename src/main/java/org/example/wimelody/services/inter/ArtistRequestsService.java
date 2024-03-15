package org.example.wimelody.services.inter;

import org.example.wimelody.dto.artistRequests.ArtistRequestsReq;
import org.example.wimelody.entities.ArtistRequests;

import java.util.List;

public interface ArtistRequestsService {
    ArtistRequests save(ArtistRequestsReq dtoMini);
    ArtistRequests reject(Long artistRequests_id);
    ArtistRequests approve(Long artistRequests_id);
    ArtistRequests findById(Long artistRequests_id);
    List<ArtistRequests> findAll();
}
