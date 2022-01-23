package com.mobileinvitation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MobileInvitationController {

    @GetMapping(value = "/information")
    public ModelAndView information() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("information");
        return modelAndView;
    }

}
