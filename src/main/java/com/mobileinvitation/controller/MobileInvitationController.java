package com.mobileinvitation.controller;

import com.mobileinvitation.model.entity.ImageEntity;
import com.mobileinvitation.model.entity.VideoEntity;
import com.mobileinvitation.model.item.SaveInfoItem;
import com.mobileinvitation.model.request.SaveInfoReq;
import com.mobileinvitation.service.MobileInvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

        List<VideoEntity> videoEntityList = new ArrayList<>();
        List<ImageEntity> imageEntityList = new ArrayList<>();

        String path = "";
        for (MultipartFile file : saveInfoReq.getImage()) {
            path = mobileInvitationService.fileUpload(file);
            VideoEntity videoEntity = VideoEntity.builder()
                    .videoName(file.getOriginalFilename())
                    .videoPath(path)
                    .build();
            videoEntityList.add(videoEntity);
        }

        for (MultipartFile file : saveInfoReq.getVideo()) {
            path = mobileInvitationService.fileUpload(file);
            ImageEntity imageEntity = ImageEntity.builder()
                    .imageName(file.getOriginalFilename())
                    .imagePath(path)
                    .build();
            imageEntityList.add(imageEntity);
        }

        //TODO 버그 수정
        SaveInfoItem saveInfoItem = saveInfoReq.toItem();
        SaveInfoItem.builder()
                .videoEntityList(videoEntityList)
                .imageEntityList(imageEntityList)
                .build();

        // TODO 디비 인서트
        mobileInvitationService.dbUpload(saveInfoItem);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");

        return modelAndView;
    }

}
