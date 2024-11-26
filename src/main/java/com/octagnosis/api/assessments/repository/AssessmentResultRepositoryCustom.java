package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.AssessmentUserResultDto;

import java.util.List;

public interface AssessmentResultRepositoryCustom {
    List<AssessmentUserResultDto> findUserResultsByAssessmentIdAndUserId(Long assessmentId, Long userId);
}
