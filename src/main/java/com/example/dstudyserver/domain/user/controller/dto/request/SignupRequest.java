package com.example.dstudyserver.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequest {
    private String email;
    private String password;
    private String introduction;
    private String image;
    private int student_id;
}
