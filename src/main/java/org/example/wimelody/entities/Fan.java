package org.example.wimelody.entities;
import java.time.LocalDateTime;

import java.util.List;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fan extends Person {
    private LocalDateTime joinedAt;
    @OneToMany
    private List<Payment> payments;
    @OneToMany
    private List<Like> likes;
    @OneToMany
    private List<Comment> comments;
}
