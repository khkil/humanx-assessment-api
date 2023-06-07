package com.octagnosis.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MemberResponseDto {

    @Data
    @AllArgsConstructor
    public static class Summary {
        private Long id;
        private String account;
    }
}
