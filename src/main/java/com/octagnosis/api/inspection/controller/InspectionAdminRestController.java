package com.octagnosis.api.inspection.controller;

import com.octagnosis.api.inspection.dto.InspectionDto;
import com.octagnosis.api.inspection.service.InspectionService;
import com.octagnosis.api.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/inspections")
public class InspectionAdminRestController {

    @Autowired
    InspectionService inspectionService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createInspection(@RequestBody InspectionDto.Request inspection) {
        inspectionService.createInspection(inspection);
        return ResponseEntity.ok(ApiResponse.createSuccessWithNoContent());
    }
}
