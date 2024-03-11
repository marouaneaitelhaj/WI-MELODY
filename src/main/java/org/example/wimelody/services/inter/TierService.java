package org.example.wimelody.services.inter;

import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.dto.tier.TierDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.UUID;

public interface TierService extends BaseService<TierDtoRsp, TierDtoReq, UUID>  {
}
