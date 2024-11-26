package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResult, Long>, AssessmentResultRepositoryCustom {
}
