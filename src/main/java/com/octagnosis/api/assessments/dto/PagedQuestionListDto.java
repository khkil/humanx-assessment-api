package com.octagnosis.api.assessments.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class PagedQuestionListDto {
    private Long questionId;
    private String questionTitle;
    private Integer questionPage;
    private List<Answer> answers;

    @QueryProjection
    public PagedQuestionListDto(Long questionId, String questionTitle, Integer questionPage, List<Answer> answers) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionPage = questionPage;
        this.answers = answers;
    }

    @Data
    public static class Answer {
        private Long answerId;
        private String answerTitle;
        private Integer answerScore;

        @QueryProjection
        public Answer(Long answerId, String answerTitle, Integer answerScore) {
            this.answerId = answerId;
            this.answerTitle = answerTitle;
            this.answerScore = answerScore;
        }
    }
}
