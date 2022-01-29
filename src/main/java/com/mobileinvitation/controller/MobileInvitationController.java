package com.mobileinvitation.controller;

import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class MobileInvitationController {
    private final MobileInvitationService mobileInvitationService;

//    @GetMapping(value = "/information")
//    public ModelAndView information() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("information");
////        modelAndView.addObject("userName", userName);
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/login")
//    public ModelAndView login() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
////        mobileInvitationService.login(userName, userPass);
////        modelAndView.addObject("userName", userName);
//
//        return modelAndView;
//    }

//    @GetMapping(value = "/login/{userName}/{userPass}")
//    public ModelAndView login(@PathVariable("userName") String userName,
//                              @PathVariable("userPass") String userPass) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        mobileInvitationService.login(userName, userPass);
////        modelAndView.addObject("userName", userName);
//
//        return modelAndView;
//    }
//

}
