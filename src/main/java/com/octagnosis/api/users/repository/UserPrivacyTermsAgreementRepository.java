package com.octagnosis.api.users.repository;

import com.octagnosis.api.users.entity.UserPrivacyTermsAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrivacyTermsAgreementRepository extends JpaRepository<UserPrivacyTermsAgreement, Long> {
}
