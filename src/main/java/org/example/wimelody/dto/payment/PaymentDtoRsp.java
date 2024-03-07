package org.example.wimelody.dto.payment;

import lombok.Data;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Tier;

import java.time.LocalDateTime;

@Data
public class PaymentDtoRsp  {
    private Long id;
    private LocalDateTime date;
    private Tier tier;

    private DBUser fan;
}
