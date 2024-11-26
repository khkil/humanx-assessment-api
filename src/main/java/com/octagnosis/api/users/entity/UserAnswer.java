package com.octagnosis.api.users.entity;

import com.octagnosis.api.assessments.entity.AssessmentAnswer;
import com.octagnosis.api.assessments.entity.AssessmentQuestion;
import com.octagnosis.api.assessments.entity.AssessmentResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@IdClass(UserAnswer.UserAnswerKey.class)
@Getter
public class UserAnswer {
    @Id
    @JoinColumn(name = "user_idx")
    @ManyToOne
    private User user;

    @Id
    @JoinColumn(name = "question_idx")
    @ManyToOne
    private AssessmentQuestion question;

    @ManyToOne
    @JoinColumn(name = "answer_idx")
    private AssessmentAnswer answer;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserAnswerKey implements Serializable {
        private User user;
        private AssessmentQuestion question;
    }
}
