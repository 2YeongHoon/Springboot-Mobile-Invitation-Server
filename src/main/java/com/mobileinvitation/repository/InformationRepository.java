package com.mobileinvitation.repository;

import com.mobileinvitation.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {

  InformationEntity findByMember(Long memberIdx);
}
