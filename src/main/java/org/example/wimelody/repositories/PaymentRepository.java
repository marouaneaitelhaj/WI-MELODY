package org.example.wimelody.repositories;


import org.example.wimelody.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByFanIdAndTierId(UUID fanId, UUID tierId);

    List<Payment> findAllByFanId(UUID fanId);
}
