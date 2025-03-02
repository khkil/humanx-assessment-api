package com.octagnosis.api.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/auth")
public class AdminAuthController {
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseEntity.ok("Success");
    }

}
