package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.entity.AssessmentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentAnswerRepository extends JpaRepository<AssessmentAnswer, Long> {
}
