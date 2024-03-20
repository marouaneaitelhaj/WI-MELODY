package org.example.wimelody.dto.tier;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TierDtoReqWithSubscribed {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private UUID artist_id;

    private String cover;

    private boolean subscribed;
}
