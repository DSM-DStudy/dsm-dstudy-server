package com.example.dstudyserver.domain.lounge.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoungeRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
