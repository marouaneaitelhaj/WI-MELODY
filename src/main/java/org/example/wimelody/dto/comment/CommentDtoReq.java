package org.example.wimelody.dto.comment;

import lombok.Data;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Pack;

import java.time.LocalDateTime;
@Data
public class CommentDtoReq {
    private Long id;
    private String content;
    private Long fan_id;
    private LocalDateTime date;

    private Long pack_id;
}
