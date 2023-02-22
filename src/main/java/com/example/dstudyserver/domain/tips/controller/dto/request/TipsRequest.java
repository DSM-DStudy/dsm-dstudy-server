package com.example.dstudyserver.domain.tips.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TipsRequest {
    private String title;
    private String content;
}
