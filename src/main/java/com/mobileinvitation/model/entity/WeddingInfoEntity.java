package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeddingInfoEntity {

    @Id
    @Column(name = "weddinginfo_id", columnDefinition = "BINARY(16)")
    @GeneratedValue
    private UUID idx;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "weddingInfo")
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "weddinginfo_idx")
    private List<VideoEntity> videoEntityList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "weddinginfo_idx")
    private List<ImageEntity> imageEntityList = new ArrayList<>();

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
