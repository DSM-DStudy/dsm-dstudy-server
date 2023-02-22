package com.example.dstudyserver.domain.good.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class GoodConflictException extends CustomException {
    public GoodConflictException(){
        super(ErrorCode.GOOD_CONFLICT);
    }
}
