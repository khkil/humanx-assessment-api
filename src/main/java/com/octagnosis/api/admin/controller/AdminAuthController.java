package com.octagnosis.api.admin.controller;

import com.octagnosis.api.admin.dto.AdminLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/auth")
public class AdminAuthController {
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody AdminLoginDto.Request params) {
        return ResponseEntity.ok(params);
    }

}
