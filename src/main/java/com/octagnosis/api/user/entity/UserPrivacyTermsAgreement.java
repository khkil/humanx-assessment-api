package com.octagnosis.api.user.entity;

import com.octagnosis.api.terms.entity.PrivacyTerms;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPrivacyTermsAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agreementIdx;

    private LocalDateTime agreementDate;

    private Boolean isAgreed;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "termsIdx")
    private PrivacyTerms privacyTerms;
}
