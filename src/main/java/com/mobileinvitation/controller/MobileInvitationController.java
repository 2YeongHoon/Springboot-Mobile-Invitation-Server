package com.mobileinvitation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MobileInvitationController {

    @GetMapping(value = "/information/userName")
    public ModelAndView information() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("information");
//        modelAndView.addObject("userName", userName);
        return modelAndView;
    }

}
