package com.mobileinvitation.form.model.item;

import com.mobileinvitation.form.model.entity.ImageEntity;
import com.mobileinvitation.form.model.entity.UserEntity;
import com.mobileinvitation.form.model.entity.VideoEntity;
import com.mobileinvitation.form.model.entity.WeddingInfoEntity;
import com.mobileinvitation.form.model.request.SaveInfoReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveInfoItem {

  private Long userIdx;
  private String userName;
  private String userPass;
  private String groomName;
  private String groomFather;
  private String groomMather;
  private String groomRelation;
  private String groomPhone;
  private String groomBank;
  private String groomAccountNum;
  private String groomAccountOwn;
  private String brideName;
  private String brideFather;
  private String brideMather;
  private String brideRelation;
  private String bridePhone;
  private String brideBank;
  private String brideAccountNum;
  private String brideAccountOwn;
  private String weddingDate;
  private String weddingHall;
  private String address;
  private String detailAddress;
  private String notice;
  private String text;
  private String greetingsBody;
  private String greetingsTitle;
  private List<VideoEntity> videoEntityList;
  private List<ImageEntity> imageEntityList;

  public UserEntity toUserEntity(WeddingInfoEntity weddingInfo) {
    UserEntity userEntity = UserEntity.builder()
        .weddingInfo(weddingInfo)
        .userName(userName)
        .userPass(userPass)
        .build();
    return userEntity;
  }

  public WeddingInfoEntity toWeddingInfoEntity() {
    WeddingInfoEntity weddingInfoEntity = WeddingInfoEntity.builder()
        .imageEntityList(imageEntityList)
        .videoEntityList(videoEntityList)
        .groomName(groomName)
        .groomFather(groomFather)
        .groomMather(groomMather)
        .groomRelation(groomRelation)
        .groomPhone(groomPhone)
        .groomBank(groomBank)
        .groomAccountNum(groomAccountNum)
        .groomAccountOwn(groomAccountOwn)
        .brideName(brideName)
        .brideFather(brideFather)
        .brideMather(brideMather)
        .brideRelation(brideRelation)
        .bridePhone(bridePhone)
        .brideBank(brideBank)
        .brideAccountNum(brideAccountNum)
        .brideAccountOwn(brideAccountOwn)
        .weddingDate(weddingDate)
        .weddingHall(weddingHall)
        .address(address)
        .detailAddress(detailAddress)
        .notice(notice)
        .text(text)
        .greetingsBody(greetingsBody)
        .greetingsTitle(greetingsTitle)
        .build();
    return weddingInfoEntity;
  }

  @Builder
  public SaveInfoItem(SaveInfoReq saveInfoReq, List<VideoEntity> videoEntity,
      List<ImageEntity> imageEntity) {
    this.userName = saveInfoReq.getUserName();
    this.userPass = saveInfoReq.getUserPass();
    this.groomName = saveInfoReq.getGroomName();
    this.groomFather = saveInfoReq.getGroomFather();
    this.groomMather = saveInfoReq.getGroomMather();
    this.groomRelation = saveInfoReq.getGroomRelation();
    this.groomPhone = saveInfoReq.getGroomPhone();
    this.groomBank = saveInfoReq.getGroomBank();
    this.groomAccountNum = saveInfoReq.getGroomAccountNum();
    this.groomAccountOwn = saveInfoReq.getGroomAccountOwn();
    this.brideName = saveInfoReq.getBrideName();
    this.brideFather = saveInfoReq.getBrideFather();
    this.brideMather = saveInfoReq.getBrideMather();
    this.brideRelation = saveInfoReq.getBrideRelation();
    this.bridePhone = saveInfoReq.getBridePhone();
    this.brideBank = saveInfoReq.getBrideBank();
    this.brideAccountNum = saveInfoReq.getBrideAccountNum();
    this.brideAccountOwn = saveInfoReq.getBrideAccountOwn();
    this.weddingDate = saveInfoReq.getWeddingDate();
    this.weddingHall = saveInfoReq.getWeddingHall();
    this.address = saveInfoReq.getAddress();
    this.detailAddress = saveInfoReq.getDetailAddress();
    this.notice = saveInfoReq.getNotice();
    this.text = saveInfoReq.getText();
    this.greetingsBody = saveInfoReq.getGreetingsBody();
    this.greetingsTitle = saveInfoReq.getGreetingsTitle();
    this.videoEntityList = videoEntity;
    this.imageEntityList = imageEntity;
  }
}
