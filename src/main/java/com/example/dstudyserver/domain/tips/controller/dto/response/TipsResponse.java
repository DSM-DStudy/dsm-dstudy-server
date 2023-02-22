package com.example.dstudyserver.domain.tips.controller.dto.response;

import com.example.dstudyserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class TipsResponse {
    private int id;
    private String title;
    private String content;
    private User user;
}
