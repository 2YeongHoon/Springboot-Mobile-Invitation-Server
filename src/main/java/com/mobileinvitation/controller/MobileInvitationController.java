package com.mobileinvitation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MobileInvitationController {


    @GetMapping("/path/{userName}/{userPass}")
    public String TestPath(@PathVariable String userName, @PathVariable String userPass) {

        log.info("userName: {}", userName);
        log.info("userPass: {}", userPass);

        return "pathsucess";
    }

    @GetMapping("/req/{userName}/{userPass}")
    public String TestReq(@RequestParam String userName, @RequestParam String userPass) {

        log.info("userName: {}", userName);
        log.info("userPass: {}", userPass);

        return "reqsucess";
    }


}
