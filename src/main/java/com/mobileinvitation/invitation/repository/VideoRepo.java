package com.mobileinvitation.invitation.repository;

import com.mobileinvitation.invitation.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<VideoEntity, Long> {

}
