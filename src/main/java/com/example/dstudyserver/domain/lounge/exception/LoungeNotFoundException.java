package com.example.dstudyserver.domain.lounge.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class LoungeNotFoundException extends CustomException {
    public LoungeNotFoundException(){
        super(ErrorCode.LOUNGE_NOT_FOUND);
    }

}
