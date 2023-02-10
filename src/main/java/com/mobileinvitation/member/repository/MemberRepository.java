package com.mobileinvitation.member.repository;

import com.mobileinvitation.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
  MemberEntity findByPhoneAndPassword(String phone, String password);
}
