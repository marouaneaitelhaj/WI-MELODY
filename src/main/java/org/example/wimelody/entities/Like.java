package org.example.wimelody.entities;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    private Long id;
    @ManyToOne
    private Fan fan;
    @ManyToOne
    private Pack pack;
}
