package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.entity.Assessment;
import com.octagnosis.api.assessments.entity.AssessmentResultContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentResultContentRepository extends JpaRepository<AssessmentResultContent, Long> {
    List<AssessmentResultContent> findByContentContaining(String content);
}
