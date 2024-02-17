package org.example.wimelody.dto.artistRequests;

import lombok.Data;
import org.example.wimelody.ArtistRequestsStatus;

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
