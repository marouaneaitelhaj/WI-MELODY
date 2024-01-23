package org.example.wimelody.repositories;

import org.example.wimelody.entities.Artist;
import org.example.wimelody.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    
}
