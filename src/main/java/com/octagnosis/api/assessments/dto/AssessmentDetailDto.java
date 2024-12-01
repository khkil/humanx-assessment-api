package com.octagnosis.api.assessments.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class AssessmentDetailDto {
    private String assessmentName;
    private Integer totalPage;

    @QueryProjection
    public AssessmentDetailDto(String assessmentName, Integer totalPage) {
        this.assessmentName = assessmentName;
        this.totalPage = totalPage;
    }
}
