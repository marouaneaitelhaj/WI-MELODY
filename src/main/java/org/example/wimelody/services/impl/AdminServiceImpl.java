package org.example.wimelody.services.impl;

import java.util.List;
import java.util.UUID;

import org.example.wimelody.dto.admin.AdminDtoReq;
import org.example.wimelody.dto.admin.AdminDtoRsp;
import org.example.wimelody.services.inter.AdminService;

public class AdminServiceImpl  implements AdminService{

    @Override
    public AdminDtoRsp save(AdminDtoReq dtoMini) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public AdminDtoRsp update(AdminDtoReq dtoMini, UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public AdminDtoRsp findOne(UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<AdminDtoRsp> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
