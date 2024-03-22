package org.example.wimelody.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private String cover;
    @OneToMany(mappedBy = "pack")
    private List<Media> media;
    @ManyToOne
    private Tier tier;

    @ManyToOne
    private DBUser artist;
}
