package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.dto.chat.ChatDtoReq;
import org.example.wimelody.dto.chat.ChatDtoRsp;
import org.example.wimelody.entities.Chat;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.repositories.ChatRepository;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.services.inter.ChatService;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    private final DBUserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public ChatDtoRsp save(ChatDtoReq dtoMini) {
        Chat chat = modelMapper.map(dtoMini, Chat.class);
        DBUser sender = userRepository.findById(dtoMini.getSender_id()).orElseThrow(() -> new RuntimeException("User not found"));
        DBUser receiver = userRepository.findById(dtoMini.getReceiver_id()).orElseThrow(() -> new RuntimeException("User not found"));
        chat.setSender(sender);
        chat.setReceiver(receiver);
        return modelMapper.map(chatRepository.save(chat), ChatDtoRsp.class);
    }

    @Override
    public ChatDtoRsp update(ChatDtoReq dtoMini, Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ChatDtoRsp findOne(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<ChatDtoRsp> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
