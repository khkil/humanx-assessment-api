package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.AssessmentUserResultDto;

import com.octagnosis.api.assessments.dto.QAssessmentUserResultDto;

import com.octagnosis.api.assessments.dto.QAssessmentUserResultDto_Content;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.octagnosis.api.users.entity.QUserAnswer.userAnswer;
import static com.octagnosis.api.users.entity.QUser.user;
import static com.octagnosis.api.assessments.entity.QAssessmentQuestion.assessmentQuestion;
import static com.octagnosis.api.assessments.entity.QAssessmentAnswer.assessmentAnswer;
import static com.octagnosis.api.assessments.entity.QAssessmentResult.assessmentResult;
import static com.octagnosis.api.assessments.entity.QAssessmentResultContent.assessmentResultContent;
import static com.octagnosis.api.assessments.entity.QAssessment.assessment;
import static com.querydsl.core.group.GroupBy.*;

@RequiredArgsConstructor
public class AssessmentResultRepositoryImpl implements AssessmentResultRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<AssessmentUserResultDto> findUserResultsByAssessmentIdAndUserId(Long assessmentId, Long userId) {
        int resultCount = queryFactory
                .select(assessment.resultCount)
                .from(assessment)
                .where(assessment.id.eq(assessmentId))
                .fetchOne();

        List<Long> topResultIds = queryFactory
                .select(assessmentResult.resultId)
                .from(userAnswer)
                .join(userAnswer.answer, assessmentAnswer)
                .join(userAnswer.question, assessmentQuestion)
                .join(assessmentQuestion.assessmentResult, assessmentResult)
                .join(assessmentQuestion.assessment, assessment)
                .join(userAnswer.user, user)
                .where(user.userIdx.eq(userId), assessment.id.eq(assessmentId))
                .groupBy(assessmentResult.resultId)
                .orderBy(assessmentAnswer.answerScore.sum().desc(), assessmentAnswer.answerId.desc())
                .limit(resultCount)
                .fetch();

        return queryFactory
                .selectFrom(assessmentResult)
                .join(assessmentResult.resultContentList, assessmentResultContent)
                .where(assessmentResult.resultId.in(topResultIds))
                .orderBy(assessmentResult.resultId.desc(), assessmentResultContent.contentType.asc())
                .transform(groupBy(assessmentResult.resultId).list(
                        new QAssessmentUserResultDto(
                                assessmentResult.resultId,
                                assessmentResult.resultName,
                                list(new QAssessmentUserResultDto_Content(
                                        assessmentResultContent.content,
                                        assessmentResultContent.contentType
                                ))
                        )
                ));
    }
}
