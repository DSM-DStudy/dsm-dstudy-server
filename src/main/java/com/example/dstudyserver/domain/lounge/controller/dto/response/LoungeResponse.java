package com.example.dstudyserver.domain.lounge.controller.dto.response;

import com.example.dstudyserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LoungeResponse {
    private int id;
    private String title;
    private String content;
    private User user;
}
