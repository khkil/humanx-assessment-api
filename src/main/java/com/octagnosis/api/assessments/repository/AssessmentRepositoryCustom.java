package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.AssessmentDetailDto;
import com.octagnosis.api.assessments.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssessmentRepositoryCustom {
    Optional<AssessmentDetailDto> findByAssessmentId(Long assessmentId);
}
