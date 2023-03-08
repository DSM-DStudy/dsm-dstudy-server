package com.example.dstudyserver.domain.study.controller.dto.request;

import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class StudyRequest {
    private String title;
    private String content;
    private String field;
    private String study_time;
    private String study_image;
    private String memo;
}
