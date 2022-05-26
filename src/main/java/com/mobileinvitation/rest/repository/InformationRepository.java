package com.mobileinvitation.rest.repository;

import com.mobileinvitation.rest.model.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationEntity, Long> {

  InformationEntity findByMember(Long memberIdx);
}
