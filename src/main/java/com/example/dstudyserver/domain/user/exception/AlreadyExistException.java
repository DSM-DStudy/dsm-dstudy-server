package com.example.dstudyserver.domain.user.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public AlreadyExistException(){
        super(ErrorCode.ALREADY_EXIST);
    }
}
