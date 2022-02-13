package com.mobileinvitation.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoRes {
    private String groomName;
    private String groomFather;
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

    private List<String> image;
    private List<String> video;
}
