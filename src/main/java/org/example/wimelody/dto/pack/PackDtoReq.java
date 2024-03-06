package org.example.wimelody.dto.pack;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.wimelody.entities.Media;
import org.example.wimelody.entities.Tier;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class PackDtoReq {
    private String name;
    private String description;
    private LocalDateTime date;
    private Long tier_id;
}
