package com.octagnosis.api.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class TestDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Request {
        private String testName;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response {
        private Long id;
        private String testName;
        private boolean isShow;
    }
}
