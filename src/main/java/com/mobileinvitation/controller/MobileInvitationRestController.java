package com.mobileinvitation.controller;

import com.mobileinvitation.model.request.CreateUserReq;
import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MobileInvitationRestController {

    private final MobileInvitationService mobileInvitationService;

    @PostMapping("/")
    public String login(@RequestBody CreateUserReq createUserReq) throws Exception {

        String result = mobileInvitationService.saveUser(createUserReq);

        return result;
    }

    @PostMapping("/info")
    public String postInfo() {
        return "";
    }

    @GetMapping
    public String getInfo() {
        return "";
    }
}
