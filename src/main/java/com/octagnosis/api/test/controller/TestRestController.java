package com.octagnosis.api.test.controller;

import com.octagnosis.api.response.ApiResponse;
import com.octagnosis.api.test.dto.TestDto;
import com.octagnosis.api.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestRestController {

    @Autowired
    TestService testService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getTestList() {
        List<TestDto.Response> testList = testService.getTestList();
        return ResponseEntity.ok(ApiResponse.createSuccess(testList));
    }
}
