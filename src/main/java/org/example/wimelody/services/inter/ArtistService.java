package org.example.wimelody.services.inter;


import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ArtistService extends BaseService<UserDtoRsp, UserDtoReq, UUID> {

    UserDtoRsp findById(UUID f, UserDtoRsp userDtoRsp);

    Page<UserDtoRsp> findAll(Pageable pageable, String text);
}
