package com.mobileinvitation.rest.service;

import com.mobileinvitation.rest.model.entity.InformationEntity;
import com.mobileinvitation.rest.model.entity.MemberEntity;
import com.mobileinvitation.rest.repository.InformationRepository;
import com.mobileinvitation.rest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MobileInvitationRestService {

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
