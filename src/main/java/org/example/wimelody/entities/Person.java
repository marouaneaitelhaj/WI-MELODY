package org.example.wimelody.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Inheritance
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "user_app", uniqueConstraints = {
        //@UniqueConstraint(columnNames = "username"),
        //@UniqueConstraint(columnNames = "email")
//})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
        

    private String points;

    @ManyToOne
    private Role role;
}
