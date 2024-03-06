package org.example.wimelody.services.inter;

import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.List;

public interface PackService extends BaseService<PackDtoRsp, PackDtoReq, Long> {
    List<PackDtoRsp> findAllByTier(Long id);
}
