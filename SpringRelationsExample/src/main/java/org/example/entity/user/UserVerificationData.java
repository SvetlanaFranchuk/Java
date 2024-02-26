package org.example.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_verification_data")
public class UserVerificationData {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "photo_link")
    private String photoLink;

    @Column(name = "voice_record_link")
    private String voiceRecordLink;

    @Column(name = "biometric_data_link")
    private String biometricDataLink;

    @Column(name = "is_verivied")
    private boolean isVerified;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

}
