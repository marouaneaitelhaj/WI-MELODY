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
public class Fan extends Person {
    @OneToMany(mappedBy = "fan")
    private List<Like> likes;

    @OneToMany(mappedBy = "fan")
    private List<Comment> comments;

    @OneToMany(mappedBy = "fan")
    private List<Payment> payments;
}
