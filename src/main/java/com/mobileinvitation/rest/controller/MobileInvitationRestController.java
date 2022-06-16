package com.mobileinvitation.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileinvitation.rest.model.entity.InformationEntity;
import com.mobileinvitation.rest.model.entity.MemberEntity;
import com.mobileinvitation.rest.model.request.SaveInfoRequest;
import com.mobileinvitation.rest.model.response.FindInfoResponse;
import com.mobileinvitation.rest.service.MobileInvitationRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MobileInvitationRestController {

    private final MobileInvitationRestService mobileInvitationRestService;
    private final ObjectMapper objectMapper;

    @GetMapping("find-info/{phone}/{password}")
    public FindInfoResponse findInfo(@PathVariable String phone, @PathVariable String password) {
        InformationEntity information = mobileInvitationRestService.findInfo(phone, password);

        FindInfoResponse res = FindInfoResponse.builder()
                .manName(information.getManName())
                .manFather(information.getManFather())
                .manMother(information.getManMother())
                .womanName(information.getWomanName())
                .womanFather(information.getWomanFather())
                .womanMother(information.getWomanMother())
                .add1(information.getAdd1())
                .add2(information.getAdd2())
                .date(information.getDate())
                .time(information.getTime())
                .text(information.getText())
                .build();
        //    FindInfoResponse res = objectMapper.convertValue(information, FindInfoResponse.class);
        return res;
    }

    @PostMapping("/save-info")
    public void saveInfo(@Valid @RequestBody SaveInfoRequest request) {

        // 웨딩 정보 저장
        InformationEntity information = InformationEntity.builder()
                .manName(request.getManName())
                .womanName(request.getWomanName())
                .manFather(request.getManFather())
                .manMother(request.getManMother())
                .womanFather(request.getWomanFather())
                .womanMother(request.getWomanMother())
                .date(request.getDate())
                .time(request.getTime())
                .add1(request.getAdd1())
                .add2(request.getAdd2())
                .text(request.getText())
                .build();

        InformationEntity informationResult = mobileInvitationRestService.saveInfo(information);

        // 유저 저장
        MemberEntity member = MemberEntity.builder()
                .phone(request.getPhone())
                .password(request.getPassword())
                .information(informationResult)
                .build();

        mobileInvitationRestService.saveMember(member);
    }
}
