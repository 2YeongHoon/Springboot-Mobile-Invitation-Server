package com.mobileinvitation.member.service;

import com.mobileinvitation.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 조회 서비스
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveMemberService {

  private final MemberService memberService;

  public Member findByMemberId(Long memberId) {
    return memberService.findByMemberId(memberId);
  }
}
