package org.example.wimelody.repositories;


import org.example.wimelody.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<User, Long> {
    
}
