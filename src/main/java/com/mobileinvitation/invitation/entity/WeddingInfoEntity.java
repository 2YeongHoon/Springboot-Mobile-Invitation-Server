package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import com.mobileinvitation.member.entity.MemberEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 웨딩정보 엔티티
 *
 * <pre>
 * </pre>
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "wedding_info")
public class WeddingInfoEntity extends RootEntity {

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "weddingInfo")
  private MemberEntity user;

  @OneToMany(
      cascade = CascadeType.ALL
      , fetch = FetchType.LAZY)
  @JoinColumn(name = "wedding_info_id")
  private List<ImageEntity> imageEntityList = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL
      , fetch = FetchType.LAZY)
  @JoinColumn(name = "wedding_info_id")
  private List<VideoEntity> videoEntityList = new ArrayList<>();

  @Column(name = "groom_name")
  private String groomName;

  @Column(name = "groom_father")
  private String groomFather;

  @Column(name = "groom_mather")
  private String groomMather;

  //TODO enum형태 변환
  @Column(name = "groom_relation")
  private String groomRelation;

  @Column(name = "groom_phone")
  private String groomPhone;

  @Column(name = "groom_bank")
  private String groomBank;

  @Column(name = "groom_account_own")
  private String groomAccountOwn;

  @Column(name = "groom_account_num")
  private String groomAccountNum;

  @Column(name = "bride_name")
  private String brideName;

  @Column(name = "bride_father")
  private String brideFather;

  @Column(name = "bride_mather")
  private String brideMather;

  //TODO enum 타입 추가
  @Column(name = "bride_relation")
  private String brideRelation;

  @Column(name = "bride_phone")
  private String bridePhone;

  @Column(name = "bride_bank")
  private String brideBank;

  @Column(name = "bride_account_own")
  private String brideAccountOwn;

  @Column(name = "bride_account_num")
  private String brideAccountNum;

  @Column(name = "wedding_hall")
  private String weddingHall;

  @Column(name = "detail_address")
  private String detailAddress;

  @Column(name = "address")
  private String address;

  @Column(name = "wedding_date")
  private String weddingDate;

  @Column(name = "greetings_title")
  private String greetingsTitle;

  @Column(name = "greetings_body")
  private String greetingsBody;

  @Column(name = "text")
  private String text;

  @Column(name = "notice")
  private String notice;
}
