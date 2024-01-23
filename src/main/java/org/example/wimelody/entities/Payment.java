package org.example.wimelody.Entities;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wimelody.Entities.Tier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private LocalDateTime date;
    @ManyToOne
    private Tier tier;
    @ManyToOne
    private Fan fan;
}
