package com.example.dstudyserver.domain.user.controller;

import com.example.dstudyserver.domain.user.controller.dto.request.LoginRequest;
import com.example.dstudyserver.domain.user.controller.dto.request.SignupRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.TokenResponse;
import com.example.dstudyserver.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request){
        authService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
