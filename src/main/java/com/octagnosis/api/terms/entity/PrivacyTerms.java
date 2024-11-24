package com.octagnosis.api.terms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octagnosis.api.users.entity.UserPrivacyTermsAgreement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrivacyTerms {
    @Id
    private Long termsIdx;

    private String termsName;

    @Column(columnDefinition = "LONGTEXT")
    private String termsContent;

    private Boolean isRequired;

    @OneToMany(mappedBy = "privacyTerms", fetch = FetchType.LAZY)
    @JsonIgnore
    List<UserPrivacyTermsAgreement> userPrivacyTermsAgreements;
}
