package org.example.wimelody.reqrsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class RegisterRequest {
    private  String username;
    private String password;
    private String profilePicture;
    private String role;
}
