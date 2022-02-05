package com.mobileinvitation.model.request;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Builder
public class SaveInfoReq implements Serializable {
    private String userName;
    private String userPass;
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
    private MultipartFile image;
    private MultipartFile video;

}
