package com.mobileinvitation.model.entity;

import javax.persistence.*;

@Entity
public class VideoEntity {
    @Id
    @GeneratedValue
    private Long idx;

    @Column
    private String video;

    @ManyToOne
    private WeddingInfoEntity weddingInfoEntity;


}
