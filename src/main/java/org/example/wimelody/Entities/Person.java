package org.example.wimelody.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    protected Long id;
    protected String fullName;
    protected String username;
    protected String email;
    protected String password;
    protected String points;
}
