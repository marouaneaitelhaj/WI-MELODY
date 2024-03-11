package org.example.wimelody.repositories;


import org.example.wimelody.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Pack> findAllByTierId(UUID id);
}
