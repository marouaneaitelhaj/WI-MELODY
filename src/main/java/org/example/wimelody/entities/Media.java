package org.example.wimelody.entities;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    private Long id;
    private String src;
    @OneToOne
    private Pack pack;
}
