package com.octagnosis.api.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPrivacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privacyIdx;

    private String userName;

    private String userPhone;

    private String userBirth;

    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;
}
