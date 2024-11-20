package com.octagnosis.api.terms.repository;

import com.octagnosis.api.terms.entity.PrivacyTerms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivacyTermsRepository extends JpaRepository<PrivacyTerms, Long> {
}
