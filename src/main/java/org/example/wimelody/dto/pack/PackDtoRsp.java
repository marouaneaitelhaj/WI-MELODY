package org.example.wimelody.dto.pack;

import lombok.Data;
import org.example.wimelody.dto.tier.TierDtoReq;

import java.time.LocalDateTime;
@Data
public class PackDtoRsp {
    private Long id;
    private String name;
    private String description;
    private String cover;
    private LocalDateTime date;
    private TierDtoReq tier;
}
