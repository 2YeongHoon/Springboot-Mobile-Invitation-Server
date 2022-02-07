package com.mobileinvitation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue
    private Long idx;

    @Column
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "weddingInfo")
    private WeddingInfoEntity weddingInfo;


}
