package com.mobileinvitation.model.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserReq {
    private String userName;
    private String userPass;
}
