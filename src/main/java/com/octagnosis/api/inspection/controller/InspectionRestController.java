package com.octagnosis.api.inspection.controller;

import com.octagnosis.api.inspection.dto.InspectionDto;
import com.octagnosis.api.inspection.service.InspectionService;
import com.octagnosis.api.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inspections")
public class InspectionRestController {

    @Autowired
    InspectionService inspectionService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getInspectionList() {
        List<InspectionDto.Response> inspectionList = inspectionService.getInspectionList();
        return ResponseEntity.ok(ApiResponse.createSuccess(inspectionList));
    }
}
