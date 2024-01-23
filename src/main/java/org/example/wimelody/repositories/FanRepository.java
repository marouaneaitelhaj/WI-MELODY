package org.example.wimelody.repositories;

import org.example.wimelody.entities.Artist;
import org.example.wimelody.entities.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FanRepository extends JpaRepository<Fan, Long> {
    
}
