package com.mobileinvitation.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VideoEntity {
    @Id
    @GeneratedValue
    private Long idx;

    @ManyToOne
    private WeddingInfoEntity weddingInfoEntity;



}
