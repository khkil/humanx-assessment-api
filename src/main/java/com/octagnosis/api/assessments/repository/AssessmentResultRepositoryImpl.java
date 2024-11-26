package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.AssessmentUserResultDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AssessmentResultRepositoryImpl implements AssessmentResultRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<AssessmentUserResultDto> findUserResultsByAssessmentIdAndUserId(Long assessmentId, Long userId) {
        return List.of();
    }
}
