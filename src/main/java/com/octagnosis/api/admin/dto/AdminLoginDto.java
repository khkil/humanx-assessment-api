package com.octagnosis.api.admin.dto;

import lombok.Data;

public class AdminLoginDto {
    @Data
    public static class Request {
        private String userId;
        private String password;
    }
}
