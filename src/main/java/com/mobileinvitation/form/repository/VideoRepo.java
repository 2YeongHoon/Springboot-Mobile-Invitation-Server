package com.mobileinvitation.form.repository;

import com.mobileinvitation.form.model.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<VideoEntity, Long> {

}
