package com.example.dstudyserver.domain.user.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class PasswordNotMatchesException extends CustomException {
    public PasswordNotMatchesException(){
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }
}
