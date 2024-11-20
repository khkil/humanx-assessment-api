package com.octagnosis.api.terms.service;

import com.octagnosis.api.terms.entity.PrivacyTerms;
import com.octagnosis.api.terms.repository.PrivacyTermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivacyTermsService {
    private final PrivacyTermsRepository privacyTermsRepository;

    public List<PrivacyTerms> getTermsList() {
        return privacyTermsRepository.findAll();
    }
}
