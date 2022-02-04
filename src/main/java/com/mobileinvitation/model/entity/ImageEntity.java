package com.mobileinvitation.model.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
public class ImageEntity {

    @Id
    @GeneratedValue
    private Long idx;

    @Column
    private String image;

    @ManyToOne
    private WeddingInfoEntity weddingInfoEntity;


}
