package org.example.wimelody.Entities;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Long id;
    private String content;
    private Person sender;
    private Person receiver;
    private LocalDateTime sentAt;
}
