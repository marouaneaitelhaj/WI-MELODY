package org.example.wimelody.Entities;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String content;
    private LocalDateTime date;
    @ManyToOne
    private Fan fan;
    @ManyToOne
    private Pack pack;
}
