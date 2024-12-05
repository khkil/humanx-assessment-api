package com.octagnosis.api.users.entity;

import com.octagnosis.api.assessments.entity.Assessment;
import jakarta.persistence.*;
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
    @Column(name = "user_idx")
    private Long userIdx;

    @OneToMany(mappedBy = "user")
    List<UserAnswer> userAnswerList;

    @OneToMany(mappedBy = "user")
    List<UserPrivacy> userPrivacyList;

    @OneToMany(mappedBy = "user")
    List<UserPrivacyTermsAgreement> userPrivacyTermsAgreements;
}
