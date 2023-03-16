package com.example.dstudyserver.domain.comment.controller.dto.response;

import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommentResponse {
    private int id;
    private String content;
    private User user;

    private Study study;
}
