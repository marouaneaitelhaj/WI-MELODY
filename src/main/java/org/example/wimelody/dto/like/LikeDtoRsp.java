package org.example.wimelody.dto.like;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Pack;
@Data
public class LikeDtoRsp {
    private Long id;
    private PackDtoReq pack;
    //private DBUserdt fan;
}
