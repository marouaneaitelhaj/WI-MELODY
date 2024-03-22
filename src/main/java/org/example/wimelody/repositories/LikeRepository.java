package org.example.wimelody.repositories;


import org.example.wimelody.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByFanIdAndPackId(UUID fan_id, Long pack_id);

    Like findByFanIdAndPackId(UUID fan_id, Long pack_id);

    int countByPackArtistId(UUID artist_id);
}
