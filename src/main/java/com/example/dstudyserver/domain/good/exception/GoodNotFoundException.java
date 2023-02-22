package com.example.dstudyserver.domain.good.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class GoodNotFoundException extends CustomException {
    public GoodNotFoundException(){
        super(ErrorCode.GOOD_NOT_FOUND);
    }
}
