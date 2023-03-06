package com.mobileinvitation.core.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 오류 정의
 */
@Getter
@AllArgsConstructor
public enum Errors {

    MISMATCH_ID_OR_PW(1001, "아이디 또는 비밀번호를 잘못 입력했습니다"),
    PRECONDITION_FAILED_UN_MATCH_CI(4002, "동일한 사용자가 아닙니다."),
    PRECONDITION_FAILED_UN_MATCH_CURRENT_PASSWORD(4003, "현재 비밀번호가 일치하지 않습니다"),

    EXTERNAL_API_ERROR(1, "요청을 처리하던 중 예상하지 못한 오류가 발생했습니다."),
    INTERNAL_SERVER_ERROR(9999, "요청을 처리하던 중 예상하지 못한 오류가 발생했습니다."),
    ;

    private final int code;
    private final String message;

    public String getCodeMessage() {
        return String.format("%s, %s", this.code, this.message);
    }
}
