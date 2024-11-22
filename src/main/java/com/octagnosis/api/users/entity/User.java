package com.octagnosis.api.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {
    @Id
    private Long userIdx;

    @OneToMany(mappedBy = "user")
    List<UserPrivacy> userPrivacyList;

    @OneToMany(mappedBy = "user")
    List<UserPrivacyTermsAgreement> userPrivacyTermsAgreements;

}
