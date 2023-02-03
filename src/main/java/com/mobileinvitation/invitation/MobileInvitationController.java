package com.mobileinvitation.invitation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileinvitation.invitation.dto.FindInfoResponse;
import com.mobileinvitation.invitation.dto.SaveInfoRequest;
import com.mobileinvitation.invitation.entity.InformationEntity;
import com.mobileinvitation.invitation.service.MobileInvitationService;
import com.mobileinvitation.member.entity.MemberEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 웨딩정보 컨트롤러
 */
@Tag(name = "웨딩정보")
@RequestMapping("/wedding")
@RestController
@RequiredArgsConstructor
public class MobileInvitationController {

    private final MobileInvitationService mobileInvitationRestService;
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
