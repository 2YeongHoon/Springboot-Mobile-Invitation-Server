package com.mobileinvitation.model.request;

import com.mobileinvitation.model.item.SaveInfoItem;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

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
    private String weddingDate;
    private String weddingHall;
    private String address;
    private String detailAddress;
    private String notice;
    private String text;
    private String greetingsBody;
    private String greetingsTitle;

    private List<MultipartFile> image;
    private List<MultipartFile> video;

//    public SaveInfoItem toItem() {
//        SaveInfoItem saveInfoItem = SaveInfoItem.builder()
//                .userName(userName)
//                .userPass(userPass)
//                .groomName(groomName)
//                .groomFather(groomFather)
//                .groomRelation(groomRelation)
//                .groomPhone(groomPhone)
//                .groomBank(groomBank)
//                .groomAccountNum(groomAccountNum)
//                .groomAccountOwn(groomAccountOwn)
//                .brideName(brideName)
//                .brideFather(brideFather)
//                .brideMather(brideMather)
//                .brideRelation(brideRelation)
//                .bridePhone(bridePhone)
//                .brideBank(brideBank)
//                .brideAccountNum(brideAccountNum)
//                .brideAccountOwn(brideAccountOwn)
//                .weddingDate(weddingDate)
//                .weddingHall(weddingHall)
//                .address(address)
//                .detailAddress(detailAddress)
//                .notice(notice)
//                .text(text)
//                .greetingsBody(greetingsBody)
//                .greetingsTitle(greetingsTitle)
//                .build();
//        return saveInfoItem;
//    }
}
