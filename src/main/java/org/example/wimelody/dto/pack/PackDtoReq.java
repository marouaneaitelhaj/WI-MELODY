package org.example.wimelody.dto.pack;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.wimelody.entities.Media;
import org.example.wimelody.entities.Tier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class PackDtoReq {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private String cover;
    private UUID tier_id;

    private boolean liked;
}
