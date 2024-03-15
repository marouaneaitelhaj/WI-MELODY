package org.example.wimelody.repositories;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, UUID> {
    Optional<DBUser> findByUsername(String username);
    List<DBUser> findAllByRole(Role role);
    Page<DBUser> findAllByRoleAndUsernameContainingIgnoreCase(Role role, String text, Pageable pageable);
    Optional<DBUser> findByIdAndRole(UUID id, Role role);
}
