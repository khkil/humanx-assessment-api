package com.octagnosis.api.users.controller;

import com.octagnosis.api.assessments.dto.AssessmentUserResultDto;
import com.octagnosis.api.response.ApiResponse;
import com.octagnosis.api.users.dto.UserPrivacyDto;
import com.octagnosis.api.users.dto.UserRegisterDto;
import com.octagnosis.api.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("{userIdx}/privacy")
    public ResponseEntity<?> saveUserPrivacy(@PathVariable Long userIdx, @RequestBody UserPrivacyDto.Request params) {
        userService.saveUserPrivacy(userIdx, params);
        return ResponseEntity.ok(ApiResponse.createSuccessWithNoContent());
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<?>> saveUser(@RequestBody UserRegisterDto.Request user) {
        UserRegisterDto.Response response = userService.registerUser(user);
        return ResponseEntity.ok(ApiResponse.createSuccess(response));
    }

    @GetMapping("/{userId}/answers")
    public ResponseEntity<?> insertUserAnswers(@PathVariable Long userId) {
        userService.insertUserAnswers(userId);
        return ResponseEntity.ok(ApiResponse.createSuccessWithNoContent());
    }
}
