package com.octagnosis.api.assessments.controller;

import com.octagnosis.api.assessments.dto.AssessmentDetailDto;
import com.octagnosis.api.assessments.dto.AssessmentUserResultDto;
import com.octagnosis.api.assessments.dto.PagedQuestionListDto;
import com.octagnosis.api.assessments.service.AssessmentService;
import com.octagnosis.api.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAssessmentDetail(@PathVariable Long id) {
        AssessmentDetailDto assessmentDetail = assessmentService.getAssessmentDetail(id);
        return ResponseEntity.ok(ApiResponse.createSuccess(assessmentDetail));
    }

    @GetMapping("/{id}/users/count")
    public ResponseEntity<?> getAssessmentUserCounts(@PathVariable Long id) {
        Long userCount = assessmentService.getAssessmentUserCount(id);
        return ResponseEntity.ok(ApiResponse.createSuccess(userCount));
    }

    @GetMapping("/{id}/questions/pages/{page}")
    public ResponseEntity<?> getAssessmentQuestions(@PathVariable Long id, @PathVariable int page) {
        List<PagedQuestionListDto> pagedQuestions = assessmentService.getPagedAssessmentQuestions(id, page);
        return ResponseEntity.ok(ApiResponse.createSuccess(pagedQuestions));
    }

    @GetMapping("/{assessmentId}/users/{userId}/result")
    public ResponseEntity<?> getAssessmentUserResult(@PathVariable Long assessmentId, @PathVariable Long userId) {
        List<AssessmentUserResultDto> userResults = assessmentService.getUserResults(assessmentId, userId);
        return ResponseEntity.ok(ApiResponse.createSuccess(userResults));
    }
}
