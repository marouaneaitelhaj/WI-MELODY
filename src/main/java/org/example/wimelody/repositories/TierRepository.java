package org.example.wimelody.repositories;

import org.example.wimelody.entities.Tier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TierRepository extends JpaRepository<Tier, Long> {
    
}
