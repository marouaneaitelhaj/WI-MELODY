package org.example.wimelody.repositories;

import org.example.wimelody.entities.Tier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TierRepository extends JpaRepository<Tier, Long> {
        Optional<Tier> findByPrice(Double price);
}
