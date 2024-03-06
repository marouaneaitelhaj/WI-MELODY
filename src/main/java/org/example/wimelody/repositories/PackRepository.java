package org.example.wimelody.repositories;


import org.example.wimelody.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Pack> findAllByTierId(Long id);
}
