package com.mobileinvitation.invitation.service;

import com.mobileinvitation.invitation.entity.WeddingInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 웨딩정보 조회 서비스
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveWeddingInfoService {

    private final MobileInvitationService mobileInvitationService;

    public WeddingInfoEntity getWeddingInfo(Long memberId){
        return mobileInvitationService.findWeddingInfoByMemberId(memberId);
    }
}
