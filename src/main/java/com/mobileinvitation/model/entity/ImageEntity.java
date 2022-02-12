package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue
//    @Column(name = "image_id")
    private Long idx;

    @Column
    private String imageName;

    @Column
    private String imagePath;

//    @ManyToOne
//    @JoinColumn(name = "weddinginfo_id")
//    private WeddingInfoEntity imageWeddingInfo;
}
