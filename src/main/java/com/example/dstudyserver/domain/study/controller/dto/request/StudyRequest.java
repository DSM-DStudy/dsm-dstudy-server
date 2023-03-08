package com.example.dstudyserver.domain.study.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class StudyRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String field;
    @NotBlank
    private String study_time;
    private String study_image;
    private String memo;
}
