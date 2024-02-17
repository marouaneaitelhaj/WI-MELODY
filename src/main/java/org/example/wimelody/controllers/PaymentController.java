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
/*
    private final PaymentService paymentService;

    public ResponseEntity<?> save(PaymentDtoReq paymentDtoReq) {
        return ResponseEntity.ok(paymentService.save(paymentDtoReq));
    }


    public ResponseEntity<?> update(PaymentDtoReq paymentDtoReq, Long aLong) {
        return ResponseEntity.ok(paymentService.update(paymentDtoReq, aLong));
    }


    public ResponseEntity<?> delete(Long aLong) {
        return ResponseEntity.ok(paymentService.delete(aLong));
    }


    public ResponseEntity<?> findById(Long aLong) {
        return ResponseEntity.ok(paymentService.findById(aLong));
    }


    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }*/
}
