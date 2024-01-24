package org.example.wimelody.dto.tier;

import lombok.Data;

@Data
public class TierDtoReq {
    private Long id;
    private String name;
    private String description;
    private Double monthlyamount;
    private Double monthlyPoints;
    private Long artist_id;
}
