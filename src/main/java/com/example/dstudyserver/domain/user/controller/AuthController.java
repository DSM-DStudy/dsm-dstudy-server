package com.example.dstudyserver.domain.user.controller;

import com.example.dstudyserver.domain.user.controller.dto.request.LoginRequest;
import com.example.dstudyserver.domain.user.controller.dto.request.SignupRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.TokenResponse;
import com.example.dstudyserver.domain.user.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public void signup(@Valid @RequestBody SignupRequest request){
        authService.signup(request);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public TokenResponse login(@Valid @RequestBody LoginRequest request){
        return authService.login(request);
    }
}
