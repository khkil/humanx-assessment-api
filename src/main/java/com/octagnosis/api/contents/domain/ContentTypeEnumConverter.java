package com.octagnosis.api.contents.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter
public class ContentTypeEnumConverter implements AttributeConverter<ContentTypeEnum, String> {
    @Override
    public String convertToDatabaseColumn(ContentTypeEnum contentTypeEnum) {
        if (contentTypeEnum == null) return null;
        return contentTypeEnum.getContent();
    }

    @Override
    public ContentTypeEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return fromCode(dbData);
    }

    private ContentTypeEnum fromCode(String dbData) {
        return Arrays.stream(ContentTypeEnum.values()).filter(v -> v.getContent().equals(dbData)).findAny().orElseThrow(() -> new IllegalArgumentException("타입 %s가 존재하지 않습니다"));
    }
}
