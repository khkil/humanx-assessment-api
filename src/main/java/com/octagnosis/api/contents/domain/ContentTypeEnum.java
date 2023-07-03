package com.octagnosis.api.contents.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContentTypeEnum {
    MAIN("MAIN", "메인 컨텐츠"),
    SUB("SUB", "서브 컨텐츠 ");

    private final String type;
    private final String content;
}
