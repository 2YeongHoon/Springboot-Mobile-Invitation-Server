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
    public String TestPath(@RequestBody CreateUserReq createUserReq) {

        mobileInvitationService.savePost(createUserReq);

        return "pathsucess";
    }
//    @GetMapping("/path/{userName}/{userPass}")
//    public String TestPath(@PathVariable String userName, @PathVariable String userPass) {
//
//        log.info("userName: {}", userName);
//        log.info("userPass: {}", userPass);
//
//        return "pathsucess";
//    }
//
//    @GetMapping("/req/{userName}/{userPass}")
//    public String TestReq(@RequestParam String userName, @RequestParam String userPass) {
//
//        log.info("userName: {}", userName);
//        log.info("userPass: {}", userPass);
//
//        return "reqsucess";
//    }


}
