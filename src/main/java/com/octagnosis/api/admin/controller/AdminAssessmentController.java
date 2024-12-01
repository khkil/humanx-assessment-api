package com.octagnosis.api.admin.controller;

import com.octagnosis.api.assessments.entity.Assessment;
import com.octagnosis.api.assessments.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/assessments")
@RequiredArgsConstructor
public class AdminAssessmentController {
    private final AssessmentService assessmentService;

    @GetMapping
    public ResponseEntity<?> getAllAssessments() {
        List<Assessment> assessments = assessmentService.getAllAssessments();
        return ResponseEntity.ok(assessments);
    }
}
