package org.example.wimelody.repositories;


import java.util.Optional;

import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
