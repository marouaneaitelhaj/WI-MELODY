package org.example.wimelody.dto.tier;

import java.util.List;
import java.util.UUID;

import org.example.wimelody.dto.pack.PackDtoForTier;
import org.example.wimelody.entities.Pack;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TierDtoRsp {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    //private List<PackDtoForTier> packs;
}
