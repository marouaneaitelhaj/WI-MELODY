package org.example.wimelody.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.chat.ChatDtoReq;
import org.example.wimelody.dto.chat.ChatDtoRsp;
import org.example.wimelody.services.inter.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class ChatController {
    public ResponseEntity<?> save(ChatDtoReq chatDtoReq) {
        return null;
    }

    public ResponseEntity<?> update(ChatDtoReq chatDtoReq, Long aLong) {
        return null;
    }

    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }

    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }

    public List<ChatDtoRsp> findAll() {
        return null;
    }
}
