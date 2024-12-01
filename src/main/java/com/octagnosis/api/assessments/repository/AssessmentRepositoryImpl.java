package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.AssessmentDetailDto;
import com.octagnosis.api.assessments.dto.QAssessmentDetailDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.octagnosis.api.assessments.entity.QAssessment.assessment;
import static com.octagnosis.api.assessments.entity.QAssessmentQuestion.assessmentQuestion;
import static com.querydsl.core.group.GroupBy.*;

@RequiredArgsConstructor
public class AssessmentRepositoryImpl implements AssessmentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<AssessmentDetailDto> findByAssessmentId(Long assessmentId) {
        return queryFactory
                .selectFrom(assessment)
                .join(assessment.assessmentQuestionList, assessmentQuestion)
                .where(assessment.id.eq(assessmentId), assessmentQuestion.isDeleted.eq(false))
                .transform(groupBy(assessment.id).list(
                        new QAssessmentDetailDto(
                                assessment.title,
                                max(assessmentQuestion.questionPage)
                        )
                ))
                .stream().findAny();
    }
}
