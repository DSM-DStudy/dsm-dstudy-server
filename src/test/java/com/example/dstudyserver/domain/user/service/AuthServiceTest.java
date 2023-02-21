package com.example.dstudyserver.domain.user.service;

import com.example.dstudyserver.domain.user.controller.dto.request.LoginRequest;
import com.example.dstudyserver.domain.user.controller.dto.request.SignupRequest;
import com.example.dstudyserver.domain.user.controller.dto.response.TokenResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    public void signup(){
        String email = "test@gmail.com";
        String password = "1234";
        String introduction = "hi";
        String image = "asdf";
        int student_id = 3100;

        SignupRequest request = new SignupRequest(email, password, introduction, image, student_id);

        authService.signup(request);
    }

    @Test
    public void login(){
        String email = "test@gmail.com";
        String password = "1234";

        LoginRequest request = new LoginRequest(email, password);

        TokenResponse tokenResponse =authService.login(request);

        System.out.println(tokenResponse.getAccessToken());
        System.out.println(tokenResponse.getRefreshToken());
    }
}
