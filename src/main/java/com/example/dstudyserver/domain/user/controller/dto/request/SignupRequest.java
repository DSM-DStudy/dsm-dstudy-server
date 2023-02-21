package com.example.dstudyserver.domain.user.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String introduction;

    private String image;

    private int student_id;
}
