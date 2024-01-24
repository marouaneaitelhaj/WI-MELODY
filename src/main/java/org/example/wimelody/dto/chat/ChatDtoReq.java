package org.example.wimelody.dto.chat;

import java.time.LocalDateTime;

import org.example.wimelody.entities.User;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDtoReq {
    private Long id;
    private String content;
    private User sender;
    private User receiver;
    private LocalDateTime sentAt;
}
