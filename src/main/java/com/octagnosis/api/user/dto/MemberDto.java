package com.octagnosis.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MemberDto {

    @Data
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String account;
    }
}
