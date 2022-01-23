package com.mobileinvitation.controller;

import com.mobileinvitation.model.request.CreateUserReq;
import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MobileInvitationController {

    private final MobileInvitationService mobileInvitationService;

    @PostMapping("/")
    public String login(@RequestBody CreateUserReq createUserReq) throws Exception {

        String result = mobileInvitationService.savePost(createUserReq);

        return result;
    }
}
