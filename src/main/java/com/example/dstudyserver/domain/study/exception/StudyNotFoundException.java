package com.example.dstudyserver.domain.study.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class StudyNotFoundException extends CustomException {
    public StudyNotFoundException(){
        super(ErrorCode.STUDY_NOT_FOUND);
    }
}
