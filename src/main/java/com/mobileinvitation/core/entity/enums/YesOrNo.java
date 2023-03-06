package com.mobileinvitation.core.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 여부 상수
 *
 * <pre>
 * {@link #Yes} 여
 * {@link #No} 부
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum YesOrNo {

    Yes("Y", "여") {

        @Override
        public boolean toBoolean() {
            return true;
        }
    },
    No("N", "부") {

        @Override
        public boolean toBoolean() {
            return false;
        }
    };

    private final String code;
    private final String title;

    /**
     * 코드에 해당되는 열거형 상수를 반환한다.
     *
     * @param code 코드
     * @return 코드에 해당되는 열거형 상수
     */
    public static Optional<YesOrNo> codeOf(String code) {
        return Arrays.stream(values()).filter(val -> val.getCode().equals(code)).findFirst();
    }

    public static YesOrNo fromBoolean(boolean bool) {
        if (bool) {
            return YesOrNo.Yes;
        }

        return YesOrNo.No;
    }

    public abstract boolean toBoolean();

    @JsonValue
    @Override
    public String toString() {
        return this.getCode();
    }
}
