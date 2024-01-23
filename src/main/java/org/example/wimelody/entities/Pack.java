package org.example.wimelody.Entities;
import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pack {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    @OneToMany(mappedBy = "pack")
    private List<Media> medias;
}
