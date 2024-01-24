package org.example.wimelody.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoReq {
    private Long id;

    private String email;
    
    private String username;

    private String password;
}
