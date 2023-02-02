package com.mobileinvitation.service;

import com.mobileinvitation.entity.InformationEntity;
import com.mobileinvitation.entity.MemberEntity;
import com.mobileinvitation.repository.InformationRepository;
import com.mobileinvitation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MobileInvitationService {

  private final InformationRepository informationRepository;
  private final MemberRepository memberRepository;

  public InformationEntity findInfo(String phone, String password) {
    MemberEntity member = memberRepository.findByPhoneAndPassword(phone, password);
//    InformationEntity information = informationRepository.findByMember(member.getIdx());

    return member.getInformation();
  }

  public void saveMember(MemberEntity memberEntity) {
    memberRepository.save(memberEntity);
  }

  public InformationEntity saveInfo(InformationEntity informationEntity) {
    return informationRepository.save(informationEntity);
  }
}
