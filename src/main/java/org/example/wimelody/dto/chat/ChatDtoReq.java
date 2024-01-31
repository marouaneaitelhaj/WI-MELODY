package org.example.wimelody.dto.chat;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDtoReq {
    private Long id;
    @NotNull
    private String content;
    @NotNull
    private Long sender_id;
    @NotNull
    private Long receiver_id;
    @NotNull
    private LocalDateTime sentAt;
}
