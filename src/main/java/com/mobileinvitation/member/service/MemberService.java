package com.mobileinvitation.member.service;

import com.mobileinvitation.member.entity.MemberEntity;
import com.mobileinvitation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 서비스
 */
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberEntity findByMemberId(Long memberId) {
    return memberRepository.getById(memberId);
  }
}
