package com.octagnosis.api.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class UserPrivacyTermsAgreement {
    @Id
    private Long AgreementIdx;

    private LocalDateTime agreementDate;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "privacyIdx")
    private UserPrivacy userPrivacy;
}
