package com.mobileinvitation.invitation.repository;

import com.mobileinvitation.invitation.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {

  InformationEntity findByMember(Long memberIdx);
}
