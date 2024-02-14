package org.example.wimelody.reqrsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.wimelody.entities.Role;

@Builder
@AllArgsConstructor
@Data
public class RegisterRequest {
    private  String username;
    private String email;
    private String password;
    private String profilePicture;
    private Role role;
}
