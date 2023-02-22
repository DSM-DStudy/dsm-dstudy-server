package com.example.dstudyserver.domain.admin.controller.dto.response;

import com.example.dstudyserver.domain.study.entity.Study;
import com.example.dstudyserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntryResponse {
    private int id;
    private User user;
    private Study study;
}
