package org.example.wimelody.dto.tier;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TierDtoReq {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Double monthlyPoints;
    @NotNull
    private UUID artist_id;
}
