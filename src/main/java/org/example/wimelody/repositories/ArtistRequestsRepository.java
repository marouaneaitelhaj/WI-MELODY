package org.example.wimelody.repositories;

import org.example.wimelody.entities.ArtistRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRequestsRepository extends JpaRepository<ArtistRequests, Long> {
}
