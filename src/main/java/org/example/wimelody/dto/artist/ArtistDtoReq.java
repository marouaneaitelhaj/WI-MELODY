package org.example.wimelody.dto.artist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.wimelody.dto.user.UserDtoReq;
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDtoReq  extends UserDtoReq {
    private String cardArtistNumber;
}
