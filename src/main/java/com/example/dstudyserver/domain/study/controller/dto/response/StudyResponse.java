package com.example.dstudyserver.domain.study.controller.dto.response;

import com.example.dstudyserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class StudyResponse {
    private int id;
    private String title;
    private String content;
    private String field;
    private String study_time;
    private String study_image;
    private String memo;
    private int like_count;
    private int people_count;
    private String creater;
    private User user;
}

