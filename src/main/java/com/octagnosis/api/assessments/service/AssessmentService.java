package com.octagnosis.api.assessments.service;

import com.octagnosis.api.assessments.entity.Assessment;
import com.octagnosis.api.assessments.repository.AssessmentRepository;
import com.octagnosis.api.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final UserRepository userRepository;

    public Long getAssessmentUserCount(Long id) {
        Assessment assessment = assessmentRepository.getReferenceById(id);
        return userRepository.countUserByAssessment(assessment);
    }


}
