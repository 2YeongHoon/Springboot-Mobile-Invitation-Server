package com.mobileinvitation.controller;

import com.mobileinvitation.model.request.SaveInfoReq;
import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class MobileInvitationController {
    private final MobileInvitationService mobileInvitationService;

    @GetMapping(value = "/information/{userName}")
    public ModelAndView information(@PathVariable("userName") String userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", userId);
        modelAndView.setViewName("information");

        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/information/upload")
    public ModelAndView information(SaveInfoReq saveInfoReq) throws Exception {
        mobileInvitationService.upload(saveInfoReq);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
