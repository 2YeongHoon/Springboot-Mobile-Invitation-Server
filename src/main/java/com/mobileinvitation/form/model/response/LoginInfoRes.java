package com.mobileinvitation.form.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoRes {

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

  private List<String> images;
  private List<String> videos;
}
