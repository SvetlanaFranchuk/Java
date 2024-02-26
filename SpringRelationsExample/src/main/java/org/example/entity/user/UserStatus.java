package org.example.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_status")
public class UserStatus {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_vip")
    private boolean is_vip;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
}
