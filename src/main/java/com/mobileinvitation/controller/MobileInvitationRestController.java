package com.mobileinvitation.controller;

import com.mobileinvitation.common.CommonResult;
import com.mobileinvitation.model.request.LoginUserReq;
import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MobileInvitationRestController {
    private final MobileInvitationService mobileInvitationService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginUserReq loginUserReq) throws Exception {
        CommonResult commonResult = mobileInvitationService.login(loginUserReq);
        return commonResult;
    }
}
