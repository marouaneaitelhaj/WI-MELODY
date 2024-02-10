package org.example.wimelody.repositories;


import java.util.Optional;

import org.example.wimelody.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, Long> {
    Optional<DBUser> findByEmail(String email);
    Optional<DBUser> findByUsername(String username);
}
