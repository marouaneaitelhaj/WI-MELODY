package org.example.wimelody.entities;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Long id;
    private String content;
    @ManyToOne
    private Person sender;
    @ManyToOne
    private Person receiver;
    private LocalDateTime sentAt;
}
