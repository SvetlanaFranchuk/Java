package org.example.entity.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expert_groups")
public class ExpertGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int group_id;

    @Enumerated(EnumType.STRING)
    private ExpertGroupName expertGroupName;

    @ManyToMany(mappedBy = "users")
    private Set<User> users = new HashSet<>();

}
