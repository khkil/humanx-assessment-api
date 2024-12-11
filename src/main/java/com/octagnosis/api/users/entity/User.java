package com.octagnosis.api.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long userIdx;

    private String userName;

    private String userBirth;

    private String userEmail;

    private String userPhone;

    @OneToMany(mappedBy = "user")
    List<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "user")
    List<UserPrivacy> userPrivacyList;

    @OneToMany(mappedBy = "user")
    List<UserPrivacyTermsAgreement> userPrivacyTermsAgreements;
}
