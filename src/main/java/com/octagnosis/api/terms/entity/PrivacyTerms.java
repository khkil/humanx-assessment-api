package com.octagnosis.api.terms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrivacyTerms {
    @Id
    private Long termsIdx;

    private String termsName;

    private String termsContent;

    private Boolean required;
}
