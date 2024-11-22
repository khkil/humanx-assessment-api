package com.octagnosis.api.users.entity;

import com.octagnosis.api.assessments.entity.Assessment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long userIdx;

    @OneToMany(mappedBy = "user")
    List<UserPrivacy> userPrivacyList;

    @OneToMany(mappedBy = "user")
    List<UserPrivacyTermsAgreement> userPrivacyTermsAgreements;

    @ManyToOne
    private Assessment assessment;
}
