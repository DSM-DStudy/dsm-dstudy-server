package com.example.dstudyserver.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditProfileRequest {
    private String introduction;
    private String image;
}
