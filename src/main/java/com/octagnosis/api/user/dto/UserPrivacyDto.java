package com.octagnosis.api.user.dto;

import lombok.Data;

public class UserPrivacyDto {
    @Data
    public static class Request {
        private String userName;
        private String userPhone;
        private String userBirth;
        private String userEmail;
    }
}
