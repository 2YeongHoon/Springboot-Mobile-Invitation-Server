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

    @GetMapping(value = "/information/{userName}/{userPass}")
    public ModelAndView information(@PathVariable("userName") String userId, @PathVariable("userPass") String userPw) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", userId);
        modelAndView.addObject("userPass", userPw);
        modelAndView.setViewName("information");

        return modelAndView;
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView information(SaveInfoReq saveInfoReq) throws Exception {
        // TODO 미디어 업로드
        // mobileInvitationService.fileUpload(saveInfoReq);

        // TODO 디비 인서트
        // mobileInvitationService.dbUpload(saveInfoReq);

        mobileInvitationService.upload(saveInfoReq);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");

        return modelAndView;
    }

}
