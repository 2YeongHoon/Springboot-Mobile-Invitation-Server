package com.mobileinvitation.invitation.service;

import com.mobileinvitation.invitation.entity.InformationEntity;
import com.mobileinvitation.member.entity.MemberEntity;
import com.mobileinvitation.invitation.repository.InformationRepository;
import com.mobileinvitation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MobileInvitationService {

  private final InformationRepository informationRepository;
  private final MemberRepository memberRepository;

  public InformationEntity findInfo(String phone, String password) {
    MemberEntity member = memberRepository.findByPhoneAndPassword(phone, password);
    return member.getInformation();
  }

  public void saveMember(MemberEntity memberEntity) {
    memberRepository.save(memberEntity);
  }

  public InformationEntity saveInfo(InformationEntity informationEntity) {
    return informationRepository.save(informationEntity);
  }
}
