package com.example.dstudyserver.domain.user.controller.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String email;
    private String password;
}
