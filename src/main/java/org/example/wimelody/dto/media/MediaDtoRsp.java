package org.example.wimelody.dto.media;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.entities.Pack;
@Data
public class MediaDtoRsp {
    private Long id;
    private String src;
    private PackDtoReq pack;
}
