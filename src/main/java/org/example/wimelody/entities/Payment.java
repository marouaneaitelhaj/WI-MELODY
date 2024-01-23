package org.example.wimelody.entities;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
