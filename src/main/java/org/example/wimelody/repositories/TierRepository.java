package org.example.wimelody.repositories;

import org.example.wimelody.entities.Tier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TierRepository extends JpaRepository<Tier, UUID> {
        Optional<Tier> findByPrice(Double price);
}
