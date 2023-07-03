package com.octagnosis.api.auth.controller;

import com.octagnosis.api.auth.dto.JwtTokenDto;
import com.octagnosis.api.auth.service.AuthService;
import com.octagnosis.api.member.domain.Member;
import com.octagnosis.api.member.dto.MemberRequestDto;
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
    public ResponseEntity<ApiResponse<JwtTokenDto>> login(@RequestBody MemberRequestDto memberRequestDto) {
        JwtTokenDto jwtTokenDto = authService.login(memberRequestDto.getAccount(), memberRequestDto.getPassword());
        return ResponseEntity.ok(ApiResponse.createSuccess(jwtTokenDto));
    }

    @RequestMapping("/sign-up")
    public ResponseEntity<ApiResponse<Member>> signUp(@RequestBody MemberRequestDto memberRequestDto) {
        Member member = authService.signUp(memberRequestDto);
        return ResponseEntity.ok(ApiResponse.createSuccess(member));
    }
}
