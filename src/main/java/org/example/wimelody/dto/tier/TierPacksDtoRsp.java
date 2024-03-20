package org.example.wimelody.dto.tier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wimelody.dto.pack.PackDtoForTier;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TierPacksDtoRsp {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private List<PackDtoForTier> packs;
}
