package org.example.wimelody.dto.chat;

import java.time.LocalDateTime;

import org.example.wimelody.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDtoRsp {
    private Long id;
    private String content;
    private Person sender;
    private Person receiver;
    private LocalDateTime sentAt;
}
