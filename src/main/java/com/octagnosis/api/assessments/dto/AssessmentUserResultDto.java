package com.octagnosis.api.assessments.dto;

import com.octagnosis.api.assessments.enums.ContentType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class AssessmentUserResultDto {
    private Long resultId;
    private String resultName;
    private List<Content> contents;

    @QueryProjection
    public AssessmentUserResultDto(Long resultId, String resultName, List<Content> contents) {
        this.resultId = resultId;
        this.resultName = resultName;
        this.contents = contents;
    }

    @Data
    @Builder
    public static class Content {
        private String content;
        private ContentType contentType;

        @QueryProjection
        public Content(String content, ContentType contentType) {
            this.content = content;
            this.contentType = contentType;
        }
    }
}
