package org.example.wimelody.repositories;

import org.example.wimelody.entities.Artist;
import org.example.wimelody.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository  extends JpaRepository<Chat, Long>{
    
}
