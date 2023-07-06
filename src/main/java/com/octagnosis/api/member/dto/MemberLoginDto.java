package com.octagnosis.api.member.dto;

import com.octagnosis.api.member.domain.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

public class MemberLoginDto {

    @Data
    public static class Request {

        private String account;
        private String password;
        private RoleEnum role;
    }

    @Data
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String account;
    }

}
