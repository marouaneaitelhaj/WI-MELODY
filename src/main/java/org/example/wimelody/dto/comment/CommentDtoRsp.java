package org.example.wimelody.dto.comment;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Pack;

import java.time.LocalDateTime;
@Data
public class CommentDtoRsp {
    private Long id;
    private String content;
    private DBUser fan;
    private LocalDateTime date;

    private PackDtoReq pack;
}
