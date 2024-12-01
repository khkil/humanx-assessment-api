package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.PagedQuestionListDto;
import com.octagnosis.api.assessments.entity.AssessmentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentQuestionRepositoryCustom {
    List<PagedQuestionListDto> findAllPagedQuestions(Long assessmentId, Integer page);
}
