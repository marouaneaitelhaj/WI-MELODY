package org.example.wimelody.repositories;


import org.example.wimelody.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
    
}
