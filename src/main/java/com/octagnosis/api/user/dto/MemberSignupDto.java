package com.octagnosis.api.user.dto;

import com.octagnosis.api.user.entity.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class MemberSignupDto {

    @Data
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Long id;
        private String account;
        private String password;
        private RoleEnum role;
    }

}
