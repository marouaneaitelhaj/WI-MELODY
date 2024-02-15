package org.example.wimelody.dto.artistRequests;

import jakarta.persistence.OneToOne;
import lombok.Data;
import org.example.wimelody.ArtistRequestsStatus;
import org.example.wimelody.entities.Admin;
import org.example.wimelody.entities.Fan;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class ArtistRequestsReq {
        private Long id;
        private UUID fan_id;

        private String ArtistName;

        private LocalDate RequestDate;
        private ArtistRequestsStatus Status;
        private UUID admin_id;
}
