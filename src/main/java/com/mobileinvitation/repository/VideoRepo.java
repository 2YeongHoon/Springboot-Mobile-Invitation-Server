package com.mobileinvitation.repository;

import com.mobileinvitation.model.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<VideoEntity, Long> {
}
