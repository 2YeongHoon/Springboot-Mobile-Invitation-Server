package com.mobileinvitation.invitation.service;

import com.mobileinvitation.invitation.dto.WeddingInfoRequest;
import com.mobileinvitation.invitation.entity.WeddingInfoEntity;
import com.mobileinvitation.invitation.repository.WeddingInfoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 웨딩정보 서비스
 */
@Service
@RequiredArgsConstructor
public class MobileInvitationService {

    private final WeddingInfoEntityRepository weddingInfoEntityRepository;

    public void save(WeddingInfoEntity entity){
        weddingInfoEntityRepository.save(entity);
    }

    public WeddingInfoEntity findWeddingInfoByMemberId(Long memberId){
        return null;
    }
}
