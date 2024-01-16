package org.example.wimelody.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tier {
    private Long id;
    private String name;
    private String description;
    private Double monthlyamount;
    private Double monthlyPoints;
}
