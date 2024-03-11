package org.example.wimelody.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Double monthlyPoints;
    @OneToMany(mappedBy = "tier")
    private List<Pack> packs;
    @ManyToOne
    private DBUser artist;
}
