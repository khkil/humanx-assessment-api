package com.octagnosis.api.user.controller;

import com.octagnosis.api.user.dto.MemberDto;
import com.octagnosis.api.user.dto.UserPrivacyDto;
import com.octagnosis.api.user.service.UserService;
import com.octagnosis.api.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
}
