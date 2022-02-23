package com.mobileinvitation.common;

import com.mobileinvitation.model.response.LoginInfoRes;
import lombok.Data;

@Data
public class CommonResult {
    private int code;
    private String message;
}
