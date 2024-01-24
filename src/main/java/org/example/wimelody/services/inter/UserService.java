package org.example.wimelody.services.inter;

import java.util.Optional;

import org.example.wimelody.dto.user.UserCredential;
import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.BaseService;

public interface UserService extends BaseService<UserDtoRsp, UserDtoReq, Long> {
    UserDtoRsp login(UserCredential userCredential);
}
