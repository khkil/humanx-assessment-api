package com.octagnosis.api.assessments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssessmentAnswer {
    @Id
    private Long answerId;

    private String answerText;

    private Integer answerScore;

    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private AssessmentQuestion question;
}
