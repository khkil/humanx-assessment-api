package com.octagnosis.api.assessments.service;

import com.octagnosis.api.assessments.dto.AssessmentDetailDto;
import com.octagnosis.api.assessments.dto.AssessmentUserResultDto;
import com.octagnosis.api.assessments.entity.Assessment;
import com.octagnosis.api.assessments.repository.AssessmentRepository;
import com.octagnosis.api.assessments.repository.AssessmentResultRepository;
import com.octagnosis.api.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final AssessmentResultRepository assessmentResultRepository;
    private final UserRepository userRepository;

    public AssessmentDetailDto getAssessmentDetail(Long id) {
        return assessmentRepository.findByAssessmentId(id).orElseThrow(() -> new ResourceNotFoundException("유효하지 않은 검사 입니다."));
    }

    public Long getAssessmentUserCount(Long id) {
        Assessment assessment = assessmentRepository.getReferenceById(id);
        return userRepository.countUserByAssessment(assessment);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public List<AssessmentUserResultDto> getUserResults(Long assessmentId, Long userId) {
        return assessmentResultRepository.findUserResultsByAssessmentIdAndUserId(assessmentId, userId);
    }
}
