package com.octagnosis.api.terms.entity;

import com.octagnosis.api.user.entity.UserPrivacyTermsAgreement;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    private String termsContent;

    private Boolean isRequired;

    @OneToMany(mappedBy = "privacyTerms")
    List<UserPrivacyTermsAgreement> userPrivacyTermsAgreements;
}
