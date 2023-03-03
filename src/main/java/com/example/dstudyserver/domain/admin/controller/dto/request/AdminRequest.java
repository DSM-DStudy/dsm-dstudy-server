package com.example.dstudyserver.domain.admin.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminRequest {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
