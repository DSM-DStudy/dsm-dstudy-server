package com.example.dstudyserver.domain.admin.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    @NotBlank
    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private int student_id;
}
