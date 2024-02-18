package org.example.wimelody.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.entities.Tier;
import org.example.wimelody.enums.Role;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRsp {
    private UUID id;


    private String username;

    private String email;

    private String profilePicture;

    private Role role;

    private List<TierDtoReq> tiers;

}
