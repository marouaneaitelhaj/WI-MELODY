package org.example.wimelody.services.inter;

import org.example.wimelody.dto.artist.ArtistDtoReq;
import org.example.wimelody.dto.artist.ArtistDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.UUID;

public interface ArtistService extends BaseService<ArtistDtoRsp, ArtistDtoReq, UUID> {
    
}
