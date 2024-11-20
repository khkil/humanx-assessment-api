package com.octagnosis.api.user.repository;

import com.octagnosis.api.user.entity.UserPrivacyTermsAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrivacyTermsAgreementRepository extends JpaRepository<UserPrivacyTermsAgreement, Long> {
}
