package com.octagnosis.api.assessments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ContentType {
    TITLE("TITLE", "제목"),
    SUMMARY("SUMMARY", "요약"),
    DESCRIPTION("DESCRIPTION", "설명"),
    DETAIL_DESCRIPTION("DETAIL_DESCRIPTION", "상세설명"),
    ADVANTAGE("ADVANTAGE", "장점"),
    DISADVANTAGE("DISADVANTAGE", "단점"),
    ;

    private final String type;
    private final String description;
}
