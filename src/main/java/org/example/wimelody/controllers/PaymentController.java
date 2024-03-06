package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.payment.PaymentDtoReq;
import org.example.wimelody.services.inter.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController  {

    private final PaymentService paymentService;

    public ResponseEntity<?> save(PaymentDtoReq paymentDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", paymentService.save(paymentDtoReq));
        response.put("message", "Payment created successfully");
        return ResponseEntity.ok(response);
    }


    public ResponseEntity<?> update(PaymentDtoReq paymentDtoReq, Long aLong) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", paymentService.update(paymentDtoReq, aLong));
        response.put("message", "Payment updated successfully");
        return ResponseEntity.ok(response);
    }


    public ResponseEntity<?> delete(Long aLong) {
        return ResponseEntity.ok(paymentService.delete(aLong));
    }


    public ResponseEntity<?> findById(Long aLong) {
        return ResponseEntity.ok(paymentService.findById(aLong));
    }


    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }
}
