package com.mobileinvitation.repository;

import com.mobileinvitation.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<VideoEntity, Long> {

}
