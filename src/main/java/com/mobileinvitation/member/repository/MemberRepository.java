package com.mobileinvitation.member.repository;

import com.mobileinvitation.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
