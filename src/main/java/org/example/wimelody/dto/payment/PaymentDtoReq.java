package org.example.wimelody.dto.payment;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Tier;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class PaymentDtoReq {
    private Long id;
    private LocalDateTime date;
    private UUID tier_id;

    private UUID fan_id;
}
