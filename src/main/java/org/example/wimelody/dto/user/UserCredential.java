package org.example.wimelody.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {

    private String email;
    
    private String username;

    private String password;
}
