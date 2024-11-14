package com.octagnosis.api.auth.controller;

import com.octagnosis.api.auth.dto.JwtTokenDto;
import com.octagnosis.api.auth.service.AuthService;
import com.octagnosis.api.user.domain.Member;
import com.octagnosis.api.user.dto.MemberLoginDto;
import com.octagnosis.api.user.dto.MemberSignupDto;
import com.octagnosis.api.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping("/login")
    public ResponseEntity<ApiResponse<JwtTokenDto>> login(@RequestBody MemberLoginDto.Request memberLoginDto) {
        JwtTokenDto jwtTokenDto = authService.login(memberLoginDto.getAccount(), memberLoginDto.getPassword());
        return ResponseEntity.ok(ApiResponse.createSuccess(jwtTokenDto));
    }

    @RequestMapping("/sign-up")
    public ResponseEntity<ApiResponse<Member>> signUp(@RequestBody MemberSignupDto.Request memberSignupDto) {
        Member member = authService.signUp(memberSignupDto);
        return ResponseEntity.ok(ApiResponse.createSuccess(member));
    }
}
