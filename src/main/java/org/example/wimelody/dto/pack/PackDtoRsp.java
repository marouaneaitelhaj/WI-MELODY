package org.example.wimelody.dto.pack;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PackDtoRsp {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
}
