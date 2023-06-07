package com.octagnosis.api.member.domain;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

public class MemberRoleConverter implements AttributeConverter<MemberRole, String> {
    @Override
    public String convertToDatabaseColumn(MemberRole role){
        if (role == null) return null;
        return role.getRole();
    }

    @Override
    public MemberRole convertToEntityAttribute(String dbData){
        if (dbData == null) return null;
        try {
            return fromCode(dbData);
        }catch (IllegalArgumentException e){
            throw e;
        }
    }

    private MemberRole fromCode(String dbData){
        return Arrays.stream(MemberRole.values()).filter(v -> v.getRole().equals(dbData)).findAny().orElseThrow(() -> new IllegalArgumentException(String.format("타입 %s가 존재하지 않습니다")));
    }
}
