package org.example.wimelody.repositories;

import org.example.wimelody.entities.ArtistRequests;
import org.example.wimelody.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRequestsRepository extends JpaRepository<ArtistRequests, Long> {
    Optional<ArtistRequests> findByFan(DBUser user);
}
