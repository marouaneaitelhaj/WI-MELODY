package org.example.wimelody.services.inter;

import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.List;
import java.util.UUID;

public interface PackService extends BaseService<PackDtoRsp, PackDtoReq, Long> {
    List<PackDtoRsp> findAll(UserDtoRsp userDtoRsp);

    List<PackDtoRsp> findAllByTier(UUID id);

    List<PackDtoRsp> findAllByArtist(UUID id, UserDtoRsp userDtoRsp);
}
