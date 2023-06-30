package com.octagnosis.api.inspection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class InspectionDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Request {
        private String inspectionName;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response {
        private Long id;
        private String inspectionName;
        private boolean isShow;
    }
}
