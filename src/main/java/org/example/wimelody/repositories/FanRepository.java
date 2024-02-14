package org.example.wimelody.repositories;

import org.example.wimelody.entities.Fan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FanRepository extends JpaRepository<Fan, UUID> {
}
