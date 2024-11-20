package com.octagnosis.api.terms.controller;

import com.octagnosis.api.response.ApiResponse;
import com.octagnosis.api.terms.entity.PrivacyTerms;
import com.octagnosis.api.terms.service.PrivacyTermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/terms")
@RequiredArgsConstructor
public class TermsController {

    private final PrivacyTermsService privacyTermsService;

    @GetMapping("")
    public ResponseEntity<?> getPrivacyTerms() {
        List<PrivacyTerms> termsList = privacyTermsService.getPrivacyTerms();
        return ResponseEntity.ok(ApiResponse.createSuccess(termsList));
    }
}
