package org.example.wimelody.repositories;


import java.util.Optional;

import org.example.wimelody.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
    Optional<Person> findByUsername(String username);
}
