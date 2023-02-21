package com.example.dstudyserver.domain.user.controller.dto.response;

import com.example.dstudyserver.domain.good.entity.Good;
import com.example.dstudyserver.domain.study.entity.Study;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserResponse {
    private String email;
    private String introduction;
    private String image;
    private int student_id;
    private Study study;
    private List<Good> goodList;
}
