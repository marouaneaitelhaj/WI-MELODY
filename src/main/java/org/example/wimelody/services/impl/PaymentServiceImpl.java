package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.audit.SpringSecurityAuditAwareImpl;
import org.example.wimelody.dto.payment.PaymentDtoReq;
import org.example.wimelody.dto.payment.PaymentDtoRsp;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Payment;
import org.example.wimelody.entities.Tier;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.repositories.PaymentRepository;
import org.example.wimelody.repositories.TierRepository;
import org.example.wimelody.services.inter.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final TierRepository tierRepository;

    private final DBUserRepository dbUserRepository;

    private final ModelMapper modelMapper;

    private  final SpringSecurityAuditAwareImpl springSecurityAuditAware;

    @Override
    public PaymentDtoRsp save(PaymentDtoReq dtoMini) {
        return getPaymentDtoRsp(dtoMini);
    }

    private PaymentDtoRsp getPaymentDtoRsp(PaymentDtoReq dtoMini) {
        Tier tier = tierRepository.findById(dtoMini.getTier_id()).orElseThrow(
                () -> new NotFoundEx("Tier not found"));
        DBUser dbUser = dbUserRepository.findById(dtoMini.getFan_id()).orElseThrow(
                () -> new NotFoundEx("DBUser not found"));
        Payment payment = modelMapper.map(dtoMini, Payment.class);
        payment.setTier(tier);
        payment.setDate(LocalDateTime.now());
        payment.setFan(dbUser);
        return modelMapper.map(paymentRepository.save(payment), PaymentDtoRsp.class);
    }

    @Override
    public PaymentDtoRsp update(PaymentDtoReq dtoMini, Long f) {
        paymentRepository.findById(f).orElseThrow(
                () -> new NotFoundEx("Payment not found"));
        return getPaymentDtoRsp(dtoMini);
    }

    @Override
    public Boolean delete(Long f) {
        Payment payment = paymentRepository.findById(f).orElseThrow(
                () -> new NotFoundEx("Payment not found"));
        paymentRepository.delete(payment);
        return true;
    }

    @Override
    public PaymentDtoRsp findById(Long f) {
        Payment payment = paymentRepository.findById(f).orElseThrow(
                () -> new NotFoundEx("Payment not found"));
        return modelMapper.map(payment, PaymentDtoRsp.class);
    }


    @Override
    public boolean checkSubscription(UUID tierId) {
        List<Payment> payment = paymentRepository.findAllByFanIdAndTierId(springSecurityAuditAware.getCurrentAuditor().getId(), tierId);
        return !payment.isEmpty();
    }

    @Override
    public List<PaymentDtoRsp> findAll() {
        List<Payment> payments = paymentRepository.findAllByFanId(springSecurityAuditAware.getCurrentAuditor().getId());
        return payments.stream().map(payment -> modelMapper.map(payment, PaymentDtoRsp.class)).toList();
    }
}
