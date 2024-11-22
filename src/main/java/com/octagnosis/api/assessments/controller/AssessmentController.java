package com.octagnosis.api.assessments.controller;

import com.octagnosis.api.assessments.service.AssessmentService;
import com.octagnosis.api.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;

    @GetMapping("/{id}/users/count")
    public ResponseEntity<?> getAssessmentUserCounts(@PathVariable Long id) {
        Long userCount = assessmentService.getAssessmentUserCount(id);
        return ResponseEntity.ok(ApiResponse.createSuccess(userCount));
    }
}
