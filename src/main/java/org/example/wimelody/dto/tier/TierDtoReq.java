package org.example.wimelody.dto.tier;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TierDtoReq {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double monthlyamount;
    @NotNull
    private Double monthlyPoints;
    @NotNull
    private Long artist_id;
}
