package com.mobileinvitation.controller;

import com.mobileinvitation.model.entity.ImageEntity;
import com.mobileinvitation.model.entity.VideoEntity;
import com.mobileinvitation.model.item.SaveInfoItem;
import com.mobileinvitation.model.request.LoginUserReq;
import com.mobileinvitation.model.request.SaveInfoReq;
import com.mobileinvitation.model.response.LoginInfoRes;
import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MobileInvitationController {
    private final MobileInvitationService mobileInvitationService;

    @GetMapping(value = "/information/{userName}/{userPass}")
    public ModelAndView information(@PathVariable("userName") String userId, @PathVariable("userPass") String userPw) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        LoginInfoRes loginUserRes = mobileInvitationService.loginInfo(userId);

        modelAndView.addObject("userName", userId);
        modelAndView.addObject("userPass", userPw);
        modelAndView.addObject("loginInfo", loginUserRes);
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

        List<VideoEntity> videoEntityList = new ArrayList<>();
        List<ImageEntity> imageEntityList = new ArrayList<>();

        imageEntityList = mobileInvitationService.imageFileUpload(saveInfoReq.getImage());
        videoEntityList = mobileInvitationService.videoFileUpload(saveInfoReq.getVideo());

        SaveInfoItem saveInfoItem = SaveInfoItem.builder()
                .saveInfoReq(saveInfoReq)
                .imageEntity(imageEntityList)
                .videoEntity(videoEntityList)
                .build();

        mobileInvitationService.dbUpload(saveInfoItem);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");

        return modelAndView;
    }

}
