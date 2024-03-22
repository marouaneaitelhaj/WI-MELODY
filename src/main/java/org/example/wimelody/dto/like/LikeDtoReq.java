package org.example.wimelody.dto.like;

import lombok.Data;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Pack;

import java.util.UUID;

@Data
public class LikeDtoReq {
    private Long id;
    private Long pack_id;
    private UUID fan_id;
}
