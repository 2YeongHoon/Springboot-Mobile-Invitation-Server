package com.mobileinvitation.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileinvitation.common.CommonResult;
import com.mobileinvitation.form.model.request.LoginUserReq;
import com.mobileinvitation.form.service.MobileInvitationService;
import com.mobileinvitation.rest.model.entity.InformationEntity;
import com.mobileinvitation.rest.model.entity.MemberEntity;
import com.mobileinvitation.rest.model.request.SaveInfoRequest;
import com.mobileinvitation.rest.service.MobileInvitationRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MobileInvitationRestController {

  private final MobileInvitationRestService mobileInvitationRestService;
  private final ObjectMapper objectMapper;

  @PostMapping("/save-info")
  public void saveInfo(@RequestBody SaveInfoRequest request) {

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
