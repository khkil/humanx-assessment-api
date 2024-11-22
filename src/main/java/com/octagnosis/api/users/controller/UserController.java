package com.octagnosis.api.users.controller;

import com.octagnosis.api.users.dto.MemberDto;
import com.octagnosis.api.users.dto.UserPrivacyDto;
import com.octagnosis.api.users.service.UserService;
import com.octagnosis.api.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
