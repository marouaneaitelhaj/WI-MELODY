package org.example.wimelody.services.inter;

import org.example.wimelody.dto.admin.AdminDtoReq;
import org.example.wimelody.dto.admin.AdminDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.UUID;

public interface AdminService extends BaseService<AdminDtoRsp, AdminDtoReq, UUID> {
    
}
