package org.example.wimelody.repositories;


import org.example.wimelody.dto.media.MediaDtoRsp;
import org.example.wimelody.entities.Media;
import org.example.wimelody.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findAllByPack(Pack pack);


}
