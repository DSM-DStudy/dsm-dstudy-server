package com.example.dstudyserver.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(400, "bad request"),
    ALREADY_EXIST(400, "already exist"),
    USER_NOT_FOUND(404, "user not found exception"),
    PASSWORD_NOT_MATCHES(400, "password not matches"),
    STUDY_NOT_FOUND(404, "study not found exception"),
    GOOD_CONFLICT(400, "good conflict exception"),
    JOIN_CONFLICT(400, "join conflict exception"),
    GOOD_NOT_FOUND(404, "good not found exception"),
    TIPS_NOT_FOUND(404, "tips not found exception"),
    LOUNGE_NOT_FOUND(404, "lounge not found exception"),
    ENTRY_NOT_FOUND(404, "entry not found exception");

    private final int httpStatus;
    private final String message;
}
