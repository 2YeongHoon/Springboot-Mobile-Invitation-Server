package com.mobileinvitation.model.entity;

import com.mobileinvitation.repository.ImageRepo;
import lombok.Builder;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
public class WeddingInfoEntity {

    @Id
    @GeneratedValue
    private Long idx;

    @OneToMany
    private List<VideoEntity> videoEntity;

    @OneToMany
    private List<ImageEntity> imageEntity;

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

    @Builder
    public WeddingInfoEntity(Long idx, String userName, String userPass, ImageEntity imageEntity, VideoEntity videoEntity) {

    }
}
