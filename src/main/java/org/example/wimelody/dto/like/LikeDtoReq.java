package org.example.wimelody.dto.like;

import lombok.Data;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Pack;
@Data
public class LikeDtoReq {
    private Long id;
    private Long pack_id;
    private Long fan_id;
}
