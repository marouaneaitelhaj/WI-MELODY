package org.example.wimelody.entities;
import java.time.LocalDateTime;


import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    //@OneToMany(mappedBy = "packs")
    //private List<Media> medias;
}
