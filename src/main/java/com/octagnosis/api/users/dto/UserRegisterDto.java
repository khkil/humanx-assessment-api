package com.octagnosis.api.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRegisterDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String userName;
        private String userPhone;
        private String userBirth;
        private String userEmail;

        private List<UserAnswer> userAnswers;
        private List<TermsAgreement> termsAgreements;

        @Data
        public static class TermsAgreement {
            private Long termsIdx;
            private Boolean isAgreed;
        }

        @Data
        public static class UserAnswer {
            private Long questionId;
            private Long answerId;
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long userIdx;
    }
}
