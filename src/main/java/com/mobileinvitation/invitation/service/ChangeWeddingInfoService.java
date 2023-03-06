package com.mobileinvitation.invitation.service;

import com.mobileinvitation.invitation.dto.WeddingInfoRequest;
import com.mobileinvitation.invitation.entity.WeddingInfo;
import com.mobileinvitation.member.entity.Member;
import com.mobileinvitation.member.service.RetrieveMemberService;
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
  private final RetrieveMemberService retrieveMemberService;

  public void save(Long memberId, WeddingInfoRequest request) {
    Member member = retrieveMemberService.findByMemberId(memberId);
    WeddingInfo weddingInfoEntity = WeddingInfo.of(member, request);
    mobileInvitationService.save(weddingInfoEntity);
  }
}
