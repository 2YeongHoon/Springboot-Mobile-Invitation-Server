package com.mobileinvitation.invitation.service;

import com.mobileinvitation.invitation.dto.WeddingInfoRequest;
import com.mobileinvitation.invitation.entity.WeddingInfoEntity;
import com.mobileinvitation.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 웨딩정보 변경 서비스
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ChangeWeddingInfoService {

    private final MobileInvitationService mobileInvitationService;

    public void save(Long memberId, WeddingInfoRequest request){
        //TODO member 조회
        MemberEntity member = null;
        WeddingInfoEntity weddingInfoEntity = WeddingInfoEntity.of(member, request);
        mobileInvitationService.save(weddingInfoEntity);
    }
}
