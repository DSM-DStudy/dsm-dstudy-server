package com.example.dstudyserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "bad request"),
    ALREADY_EXIST(400, "already exist"),
    USER_NOT_FOUND(400, "user not found exception"),
    PASSWORD_NOT_MATCHES(400, "password not matches");

    private final int httpStatus;
    private final String message;
}
