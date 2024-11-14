package com.octagnosis.api.user.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter
public class RoleEnumConverter implements AttributeConverter<RoleEnum, String> {
    @Override
    public String convertToDatabaseColumn(RoleEnum role) {
        if (role == null) return null;
        return role.getRole();
    }

    @Override
    public RoleEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        try {
            return fromCode(dbData);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private RoleEnum fromCode(String dbData) {
        return Arrays.stream(RoleEnum.values()).filter(v -> v.getRole().equals(dbData)).findAny().orElseThrow(() -> new IllegalArgumentException(String.format("타입 %s가 존재하지 않습니다")));
    }
}
