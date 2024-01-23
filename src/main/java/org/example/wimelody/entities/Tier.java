package org.example.wimelody.entities;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tier {
    private Long id;
    private String name;
    private String description;
    private Double monthlyamount;
    private Double monthlyPoints;
    @OneToMany(mappedBy = "tier")
    private List<Pack> packs;
    @ManyToOne
    private Artist artist;
}
