package org.example.wimelody.services.inter;


import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.UUID;

public interface ArtistService extends BaseService<UserDtoRsp, UserDtoReq, UUID> {
    
}
