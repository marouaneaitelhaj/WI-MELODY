package org.example.wimelody.services.inter;

import java.util.List;

public interface ArtistRequests {
    ArtistRequests save(ArtistRequests dtoMini);
    ArtistRequests reject(ArtistRequests dtoMini);
    ArtistRequests approve(ArtistRequests dtoMini);
    ArtistRequests findById(ArtistRequests f);
    List<ArtistRequests> findAll();
}
