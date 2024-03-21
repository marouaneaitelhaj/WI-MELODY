package org.example.wimelody.services.inter;

import org.example.wimelody.dto.payment.PaymentDtoReq;
import org.example.wimelody.dto.payment.PaymentDtoRsp;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.BaseService;

import java.util.List;
import java.util.UUID;

public interface PaymentService extends BaseService<PaymentDtoRsp, PaymentDtoReq, Long> {
    boolean checkSubscription(UUID tierId);
}
