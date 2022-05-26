package com.mobileinvitation.form.repository;

import com.mobileinvitation.form.model.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<ImageEntity, Long> {

}