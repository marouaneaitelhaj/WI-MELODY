package org.example.wimelody.dto.chat;

import java.time.LocalDateTime;

import org.example.wimelody.entities.DBUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDtoRsp {
    private Long id;
    private String content;
    private DBUser sender;
    private DBUser receiver;
    private LocalDateTime sentAt;
}
