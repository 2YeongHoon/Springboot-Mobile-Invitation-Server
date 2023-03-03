package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import com.mobileinvitation.invitation.dto.WeddingInfoRequest;
import com.mobileinvitation.invitation.enums.Family;
import com.mobileinvitation.member.entity.MemberEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 웨딩정보 엔티티
 *
 * <pre>
 * </pre>
 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "wedding_info")
public class WeddingInfoEntity extends RootEntity {

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "member_id", referencedColumnName = "id")
  private MemberEntity member;

  @Column(name = "groom_name")
  private String groomName;

  @Column(name = "groom_father")
  private String groomFather;

  @Column(name = "groom_mather")
  private String groomMather;

  @Column(name = "groom_relation")
  private Family groomRelation;

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

  @Column(name = "bride_relation")
  private Family brideRelation;

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
  private LocalDateTime weddingDate;

  @Column(name = "greetings_title")
  private String greetingsTitle;

  @Column(name = "greetings_body")
  private String greetingsBody;

  @Column(name = "notice")
  private String notice;

  private WeddingInfoEntity(MemberEntity memberId, WeddingInfoRequest request){
    this.member = memberId;
    this.groomName = request.getGroomName();
    this.groomFather = request.getGroomFather();
    this.groomMather = request.getGroomMather();
    this.groomRelation = request.getGroomRelation();
    this.groomPhone = request.getGroomPhone();
    this.groomBank = request.getGroomBank();
    this.groomAccountOwn = request.getGroomAccountOwn();
    this.groomAccountNum = request.getGroomAccountNum();
    this.brideName = request.getBrideName();
    this.brideFather = request.getBrideFather();
    this.brideMather = request.getBrideMather();
    this.brideRelation = request.getBrideRelation();
    this.bridePhone = request.getBridePhone();
    this.brideBank = request.getBrideBank();
    this.brideAccountOwn = request.getBrideAccountOwn();
    this.brideAccountNum = request.getBrideAccountNum();
    this.weddingHall = request.getWeddingHall();
    this.detailAddress = request.getDetailAddress();
    this.weddingDate = request.getWeddingDate();
    this.greetingsTitle = request.getGreetingsTitle();
    this.greetingsBody = request.getGreetingsBody();
    this.notice = request.getNotice();
  }
  public static WeddingInfoEntity of(MemberEntity memberId, WeddingInfoRequest request){
    return  new WeddingInfoEntity(memberId, request);
  }
}
