package com.mobileinvitation.invitation.service;

import com.mobileinvitation.invitation.entity.WeddingInfo;
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

  public void save(WeddingInfo entity) {
    weddingInfoEntityRepository.save(entity);
  }

  public WeddingInfo findWeddingInfoByMemberId(Long memberId) {
    return null;
  }
}
