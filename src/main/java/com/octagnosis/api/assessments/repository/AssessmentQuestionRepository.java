package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.entity.AssessmentQuestion;
import com.octagnosis.api.assessments.entity.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestion, Long>, AssessmentQuestionRepositoryCustom {
}
