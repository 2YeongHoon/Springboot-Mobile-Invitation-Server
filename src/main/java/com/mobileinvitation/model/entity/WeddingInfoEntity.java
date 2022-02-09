package com.mobileinvitation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeddingInfoEntity {

    @Id
    @GeneratedValue
    @Column(name = "weddinginfo_id")
    private Long idx;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    private List<VideoEntity> videoEntityList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private List<ImageEntity> imageEntityList;

    @Column
    private String groomName;

    @Column
    private String groomFather;

    @Column
    private String groomMather;

    @Column // enum 설정필요
    private String groomRelation;

    @Column
    private String groomPhone;

    @Column
    private String groomBank;

    @Column
    private String groomAccountOwn;

    @Column
    private String groomAccountNum;

    @Column
    private String brideName;

    @Column
    private String brideFather;

    @Column
    private String brideMather;

    @Column // enum 설정필요
    private String brideRelation;

    @Column
    private String bridePhone;

    @Column
    private String brideBank;

    @Column
    private String brideAccountOwn;

    @Column
    private String brideAccountNum;

    @Column
    private String weddingHall;

    @Column
    private String detailAddress;

    @Column
    private String address;

    @Column
    private String wayToCome;

    @Column
    private String weddingDate;

    @Column
    private String greetingsTitle;

    @Column
    private String greetingsBody;

    @Column
    private String text;

    @Column
    private String notice;

}
