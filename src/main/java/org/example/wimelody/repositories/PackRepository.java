package org.example.wimelody.repositories;

import org.example.wimelody.entities.Artist;
import org.example.wimelody.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Long> {
    
}
