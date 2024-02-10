package org.example.wimelody.repositories;

import org.example.wimelody.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<DBUser,Long>{
}
