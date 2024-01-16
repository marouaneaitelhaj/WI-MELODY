package org.example.wimelody.Entities;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

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
