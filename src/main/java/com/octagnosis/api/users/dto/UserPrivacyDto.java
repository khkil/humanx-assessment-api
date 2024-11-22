package com.octagnosis.api.users.dto;

import lombok.Data;

import java.util.List;

public class UserPrivacyDto {

    @Data
    public static class Request {
        private String userName;
        private String userPhone;
        private String userBirth;
        private String userEmail;

        private List<TermsAgreement> termsAgreements;

        @Data
        public static class TermsAgreement {
            private Long termsIdx;
            private Boolean isAgreed;
        }
    }
}
