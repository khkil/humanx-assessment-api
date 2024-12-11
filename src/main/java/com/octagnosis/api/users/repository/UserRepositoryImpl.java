package com.octagnosis.api.users.repository;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.OracleTemplates;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import static com.octagnosis.api.users.entity.QUser.user;
import static com.octagnosis.api.users.entity.QUserAnswer.userAnswer;
import static com.octagnosis.api.assessments.entity.QAssessmentQuestion.assessmentQuestion;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    @Override
    public Long countByAssessmentId(Long assessmentId) {
        StringPath subQueryAlias = Expressions.stringPath("userAnswer");

        NumberExpression<Long> userIdx = Expressions.numberPath(Long.class, subQueryAlias, "user_idx");
        NumberExpression<Long> questionIdx = Expressions.numberPath(Long.class, subQueryAlias, "question_idx");

        JPASQLQuery<?> jpaSqlQuery = new JPASQLQuery<>(entityManager, MySQLTemplates.DEFAULT);
        return jpaSqlQuery.select(user.userIdx.count())
                .from(user)
                .join(queryFactory
                                .select(
                                        userIdx,
                                        questionIdx.min().as("question_idx")
                                )
                                .from(userAnswer)
                                .groupBy(userIdx),
                        subQueryAlias
                )
                .on(user.userIdx.eq(userIdx))
                .join(assessmentQuestion).on(assessmentQuestion.questionId.eq(questionIdx))
                .fetchOne();
    }
}
