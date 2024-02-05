package org.example.wimelody.repositories;

import org.example.wimelody.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository  extends JpaRepository<Artist, Long> {
}
