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
    @Column(name = "image_id")
    private Long idx;

    @Column
    private String imageName;

    @Column
    private String imagePath;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idx")
    private WeddingInfoEntity imageWeddingInfo;
}
