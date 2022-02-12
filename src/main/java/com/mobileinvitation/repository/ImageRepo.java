package com.mobileinvitation.repository;

import com.mobileinvitation.model.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepo extends JpaRepository<ImageEntity, Long> {

    //TODO Image, Video remove 구현
    void deleteByWeddingInfoIdx(Long weddingInfoIdx);
}
