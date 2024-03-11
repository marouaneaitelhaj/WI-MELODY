package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.payment.PaymentDtoReq;
import org.example.wimelody.services.inter.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController  {

    private final PaymentService paymentService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_FAN')")
    public ResponseEntity<?> save(@RequestBody PaymentDtoReq paymentDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", paymentService.save(paymentDtoReq));
        response.put("message", "Payment created successfully");
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{aLong}")
    public ResponseEntity<?> update(@RequestBody PaymentDtoReq paymentDtoReq, @PathVariable Long aLong) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", paymentService.update(paymentDtoReq, aLong));
        response.put("message", "Payment updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{aLong}")
    public ResponseEntity<?> delete(@PathVariable Long aLong) {
        return ResponseEntity.ok(paymentService.delete(aLong));
    }

    @GetMapping("/{aLong}")
    public ResponseEntity<?> findById(@PathVariable Long aLong) {
        return ResponseEntity.ok(paymentService.findById(aLong));
    }

@GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }
}
