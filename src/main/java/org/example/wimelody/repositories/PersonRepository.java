package org.example.wimelody.repositories;

import org.example.wimelody.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person ,Long>{
}
