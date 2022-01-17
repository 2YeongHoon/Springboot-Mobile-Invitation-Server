package com.mobileinvitation.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ImageEntity {

    @Id
    @GeneratedValue
    private Long idx;

    @ManyToOne
    private WeddingInfoEntity weddingInfoEntity;

}
