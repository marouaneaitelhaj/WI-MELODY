package org.example.wimelody.Entities;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    private String cardArstistNumber;
    @OneToMany(mappedBy = "artist")
    private List<Tier> tiers;
}
