package com.example.dstudyserver.domain.study.controller.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditStudyRequest {

    private String title;

    private String content;

    private String field;

    private String study_time;

    private String study_image;

    private String memo;
}
