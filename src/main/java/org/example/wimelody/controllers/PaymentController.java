package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.payment.PaymentDtoReq;
import org.example.wimelody.dto.payment.PaymentDtoRsp;
import org.example.wimelody.services.inter.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController  {

    public ResponseEntity<?> save(PaymentDtoReq paymentDtoReq) {
        return null;
    }


    public ResponseEntity<?> update(PaymentDtoReq paymentDtoReq, Long aLong) {
        return null;
    }


    public Boolean delete(Long aLong) {
        return null;
    }


    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }


    public List<PaymentDtoRsp> findAll() {
        return null;
    }
}
