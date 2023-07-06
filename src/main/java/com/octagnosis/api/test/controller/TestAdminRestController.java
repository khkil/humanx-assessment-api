package com.octagnosis.api.test.controller;

import com.octagnosis.api.response.ApiResponse;
import com.octagnosis.api.test.dto.TestDto;
import com.octagnosis.api.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/tests")
public class TestAdminRestController {

    @Autowired
    TestService testService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createTest(@RequestBody TestDto.Request test) {
        testService.createTest(test);
        return ResponseEntity.ok(ApiResponse.createSuccessWithNoContent());
    }
}
