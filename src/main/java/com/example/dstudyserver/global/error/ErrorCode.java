package com.example.dstudyserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "bad request");

    private final int httpStatus;
    private final String message;
}
