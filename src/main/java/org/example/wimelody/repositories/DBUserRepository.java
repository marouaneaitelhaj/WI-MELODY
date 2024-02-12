package org.example.wimelody.repositories;


import java.util.Optional;
import java.util.UUID;

import org.example.wimelody.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, UUID> {
    Optional<DBUser> findByUsername(String username);
}
