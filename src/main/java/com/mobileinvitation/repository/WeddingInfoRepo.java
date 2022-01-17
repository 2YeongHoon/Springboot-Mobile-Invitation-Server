package com.mobileinvitation.repository;

import com.mobileinvitation.model.entity.WeddingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeddingInfoRepo extends JpaRepository<WeddingInfoEntity, Long> {
}
