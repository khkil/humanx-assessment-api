package com.octagnosis.api.assessments.repository;

import com.octagnosis.api.assessments.dto.PagedQuestionListDto;
import com.octagnosis.api.assessments.dto.QPagedQuestionListDto;
import com.octagnosis.api.assessments.dto.QPagedQuestionListDto_Answer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.octagnosis.api.assessments.entity.QAssessmentQuestion.assessmentQuestion;
import static com.octagnosis.api.assessments.entity.QAssessment.assessment;
import static com.octagnosis.api.assessments.entity.QAssessmentAnswer.assessmentAnswer;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@RequiredArgsConstructor
public class AssessmentQuestionRepositoryImpl implements AssessmentQuestionRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<PagedQuestionListDto> findAllPagedQuestions(Long assessmentId, Integer page) {
        return queryFactory
                .selectFrom(assessmentQuestion)
                .join(assessmentQuestion.assessment, assessment)
                .join(assessmentQuestion.answers, assessmentAnswer)
                .where(assessment.id.eq(assessmentId),
                        assessmentQuestion.questionPage.eq(page),
                        assessmentQuestion.isDeleted.eq(false)
                )
                .orderBy(assessmentQuestion.questionId.asc(),
                        assessmentAnswer.answerId.desc()
                )
                .transform(groupBy(assessmentQuestion.questionId).list(
                        new QPagedQuestionListDto(
                                assessmentQuestion.questionId,
                                assessmentQuestion.questionTitle,
                                assessmentQuestion.questionPage,
                                list(
                                        new QPagedQuestionListDto_Answer(
                                                assessmentAnswer.answerId,
                                                assessmentAnswer.answerText,
                                                assessmentAnswer.answerScore
                                        )
                                )
                        )

                ));
    }
}
