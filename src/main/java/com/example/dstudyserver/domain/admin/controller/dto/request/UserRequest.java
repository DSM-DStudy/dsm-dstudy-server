package com.example.dstudyserver.domain.admin.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    private int id;
    private String email;
    private String password;
    private int student_id;
}
