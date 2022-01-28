package com.mobileinvitation.model.request;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class LoginUserReq implements Serializable {
    private String userName;
    private String userPass;
}
