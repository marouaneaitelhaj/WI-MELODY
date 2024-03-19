package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.payment.PaymentDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.services.impl.AuthenticationService;
import org.example.wimelody.services.inter.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController  {

    private final PaymentService paymentService;

    private  final AuthenticationService authenticationService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_FAN')")
    public ResponseEntity<?> save(@RequestBody PaymentDtoReq paymentDtoReq) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", paymentService.save(paymentDtoReq));
        response.put("message", "Payment created successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-subscription/{tier_id}")
    @PreAuthorize("hasAnyAuthority('ROLE_FAN')")
    public ResponseEntity<?> checkSubscription(@PathVariable UUID tier_id, Principal principal) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", paymentService.checkSubscription(
                authenticationService.getUser(principal.getName()).getId(), tier_id));
        response.put("message", "Subscription checked successfully");
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
public ResponseEntity<?> findAll(Principal principal) {
    UserDtoRsp userDtoRsp = authenticationService.getUser(principal.getName());
        return ResponseEntity.ok(paymentService.findAll(userDtoRsp));
    }
}
