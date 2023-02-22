package com.example.dstudyserver.domain.admin.exception;

import com.example.dstudyserver.global.error.ErrorCode;
import com.example.dstudyserver.global.error.exception.CustomException;

public class EntryNotFoundException extends CustomException {
    public EntryNotFoundException(){
        super(ErrorCode.ENTRY_NOT_FOUND);
    }
}
