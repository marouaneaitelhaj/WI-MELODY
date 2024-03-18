package org.example.wimelody.repositories;


import org.example.wimelody.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Pack> findAllByTierId(UUID id);

    List<Pack> findAllByTierArtistId(UUID id);

    @Query("SELECT p FROM Pack p INNER JOIN p.tier t INNER JOIN t.payments pm WHERE pm.fan.id = :fanId")
    List<Pack> findAllByFanId(@Param("fanId") UUID fanId);

    @Query("SELECT p FROM Pack p INNER JOIN p.tier t INNER JOIN t.payments pm WHERE pm.fan.id = :fanId AND t.artist.id = :artistId")
    List<Pack> findAllByFanIdAndArtistId(@Param("fanId") UUID fanId, @Param("artistId") UUID artistId);


}
