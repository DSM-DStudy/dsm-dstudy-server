package com.example.dstudyserver.domain.tips.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class TipsNotFoundException extends CustomException {
    public TipsNotFoundException(){
        super(ErrorCode.TIPS_NOT_FOUND);
    }
}
