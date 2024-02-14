package org.example.wimelody.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wimelody.entities.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoReq {
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String profilePicture;
    @NotNull
    private Role role;
}
