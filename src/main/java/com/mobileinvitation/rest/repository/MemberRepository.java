package com.mobileinvitation.rest.repository;

import com.mobileinvitation.rest.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

  MemberEntity findByPhoneAndPassword(String phone, String password);
}
