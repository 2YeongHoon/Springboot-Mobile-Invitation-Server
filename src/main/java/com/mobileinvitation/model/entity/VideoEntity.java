package com.mobileinvitation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue
    private Long idx;

    @Column
    private String video;

    @ManyToOne
    @JoinColumn(name="weddingInfo")
    private WeddingInfoEntity weddingInfo;


}
