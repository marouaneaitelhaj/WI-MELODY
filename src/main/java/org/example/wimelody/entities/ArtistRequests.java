package org.example.wimelody.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wimelody.ArtistRequestsStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArtistRequests {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Fan fan;

    private String ArtistName;

    private LocalDate RequestDate;
    private ArtistRequestsStatus Status;
    @OneToOne
    private Admin admin;
}
