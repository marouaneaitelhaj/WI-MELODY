package org.example.wimelody.services.inter;

import org.example.wimelody.dto.media.MediaDtoReq;
import org.example.wimelody.dto.media.MediaDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.List;

public interface MediaService  extends BaseService<MediaDtoRsp, MediaDtoReq, Long>{
    List<MediaDtoRsp> findAllByPack(Long id);
    List<MediaDtoRsp> save(List<MediaDtoReq> mediaDtoReq);
}
