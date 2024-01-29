package org.example.wimelody.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fan extends  User {
    @OneToMany
    private List<Like> likes;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Payment> payments;
}
