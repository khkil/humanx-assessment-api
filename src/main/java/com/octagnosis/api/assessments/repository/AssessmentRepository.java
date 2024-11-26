package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    Long countAssessmentById(Long id);
}
